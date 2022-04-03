package com.alucar.domain.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // classe de configuração que deve ser carregada durante inicialização do servidor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override //
    protected void configure(HttpSecurity http) throws Exception {
        //nossa própria configuração de seguraça.
        http.authorizeRequests() //indica que todas as solicitações estão protegidas, é necessário logar para acessar
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic(); //ativa a proteção HTTP básica, apresenta uma caixapara usuário e senha
                .antMatchers("/home").hasRole("USER")
                .antMatchers("/cadastrar").hasRole("ADMIN")
                .and().formLogin()
                .and().logout();


    }

}
