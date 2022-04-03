package com.alucar.domain.service;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

    @Service
    public class AuthenticationService {
        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private TokenService tokenService;

        @Autowired
        private ClienteService clientService;

        public TokenDto signIn (SigInForm form) throws ForbiddenException {
            UserNamePasswordAuthenticationToken authToken =
                    new UserNamePasswordAuthenticationToken(form.getEmail(), form.getPassword());

            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = tokenService.generateToken(authentication);

            User user;
            try {
                Long id = tokenService.getUserIdFromToken(token);
                user = clientService.findById(id);
            }catch (ResourceNotFoundException e) {
                throw new ForbiddenException();
            }
            return new TokenDto(token, "Bearer", user);

        }
        public void signUp (SignUpForm form) {
            Client client = new Client();
            client.setEmail(form.getEmail());
            client.setPassword(form.getPassword());
            client.setName(form.getName());
            client.setLastName(form.getLastName());
        }


    }







