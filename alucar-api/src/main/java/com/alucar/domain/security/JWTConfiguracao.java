package com.alucar.domain.security;


import com.alucar.domain.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;




@EnableWebSecurity
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

    private final UserDetailsService clienteService;
    private PasswordEncoder passwordEncoder;


    public JWTConfiguracao(UserDetailsService clienteService, PasswordEncoder passwordEncoder) {
        this.clienteService = clienteService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clienteService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()

                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/cadastrar").permitAll()


//                .antMatchers(HttpMethod.GET, "/carro").permitAll()
//                .antMatchers(HttpMethod.POST, "/carro").permitAll()
//                .antMatchers(HttpMethod.PUT, "/carro").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/carro").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/pedido").permitAll()
//                .antMatchers(HttpMethod.POST, "/pedido").permitAll()
//                .antMatchers(HttpMethod.PUT, "/pedido").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/pedido").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/clientes").permitAll()
//                .antMatchers(HttpMethod.POST, "/clientes").permitAll()
//                .antMatchers(HttpMethod.PUT, "/clientes").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/clientes").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/imagens").permitAll()
//                .antMatchers(HttpMethod.POST, "/imagens").permitAll()
//                .antMatchers(HttpMethod.PUT, "/imagens").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/imagens").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/caracteristicas").permitAll()
//                .antMatchers(HttpMethod.POST, "/caracteristicas").permitAll()
//                .antMatchers(HttpMethod.PUT, "/caracteristicas").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/caracteristicas").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/categorias").permitAll()
//                .antMatchers(HttpMethod.POST, "/categorias").permitAll()
//                .antMatchers(HttpMethod.PUT, "/categorias").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/categorias").permitAll()
//
//                .antMatchers(HttpMethod.POST, "/cidades").permitAll()
//                .antMatchers(HttpMethod.GET, "/cidades").permitAll()
//                .antMatchers(HttpMethod.PUT, "/cidades").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/cidades").permitAll()

                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAutenticarFiltro(authenticationManager()))
                .addFilter(new JWTValidarFiltro(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

            CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
            source.registerCorsConfiguration("/**", corsConfiguration);

            return source;
        }
}
