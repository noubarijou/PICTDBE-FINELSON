package com.alucar.domain.security;

import com.alucar.domain.data.DetalheClienteData;
import com.alucar.domain.model.Cliente;
import com.alucar.domain.service.ClienteService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAutenticarFiltro extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRACAO = 3_600_000;   //60 minutos

    public static final String TOKEN_SENHA = "2c92dd70-ae49-4503-b813-43d1b98f4d99"; // senha gerada no site "https://guidgenerator.com/"

    private final AuthenticationManager authenticationManager;

    public JWTAutenticarFiltro(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            Cliente cliente = new ObjectMapper()
                    .readValue(request.getInputStream(), Cliente.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    cliente.getEmail(),
                    cliente.getSenha(),
                    new ArrayList<>()     // trocar por permissões de usuários
            ));

        } catch (IOException e) {
            throw new RuntimeException("Falha ao Autenticar usuário", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        DetalheClienteData clienteData = (DetalheClienteData) authResult.getPrincipal();

        String token = JWT.create().
                withSubject(clienteData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))  // milisegundos atuais + tempo do TOKEN_EXPIRACAO, expira o tempo do token
                .sign(Algorithm.HMAC512(TOKEN_SENHA));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}
