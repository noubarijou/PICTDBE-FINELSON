package com.alucar.domain.security;

import com.alucar.domain.model.Cliente;
import com.alucar.domain.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final ClienteRepository clienteRepository;

    public TokenAuthenticationFilter(TokenService tokenService, ClienteRepository repository) {
        this.tokenService = tokenService;
        this.clienteRepository = repository;
    }


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token = recoverToken(request);
        if(tokenService.isValid(token)){
            try {
                authenticateUser(token);
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().write("Não Autorizado");
                response.setStatus(HttpStatus.FORBIDDEN.value());
            }
        }
        filterChain.doFilter(request, response);
    }

    private void authenticateUser(String token) throws ForbiddenException {
        Long userId = tokenService.getUserIdFromToken(token);
        User user = clienteRepository.findById(userId).orElse(null);

        if(user == null) {
            throw new ForbiddenException();
        }

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7);
    }
}
