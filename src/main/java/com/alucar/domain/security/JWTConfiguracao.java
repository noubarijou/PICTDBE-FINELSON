package com.alucar.domain.security;



import com.alucar.domain.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static com.alucar.domain.model.Funcao.*;

@EnableWebSecurity
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl clienteService;
    private final PasswordEncoder passwordEncoder;


    public JWTConfiguracao(UserDetailsServiceImpl clienteService, PasswordEncoder passwordEncoder) {
        this.clienteService = clienteService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clienteService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String funcao_ADMIN = ADMIN.name();
        String funcao_MODERADOR = MODERADOR.name();
        String funcao_CLIENTE = CLIENTE.name();


        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())

                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login/**").permitAll()
                .antMatchers(HttpMethod.POST, "/clientes/cadastrar").permitAll()
                .antMatchers(HttpMethod.POST, "/clientes/atualizar").permitAll()
                .antMatchers(HttpMethod.GET, "clientes/**").permitAll()
                .antMatchers(HttpMethod.GET, "pedido/**").permitAll()
                .antMatchers(HttpMethod.POST, "/pedido").hasAuthority(funcao_ADMIN)
                .antMatchers(HttpMethod.POST, "/carro/**").permitAll()
                .antMatchers(HttpMethod.POST, "/clientes/validarSenha").permitAll()

//                .antMatchers(HttpMethod.GET, "/carro").permitAll()
//                .antMatchers(HttpMethod.GET, "/clientes").permitAll()
//                .antMatchers(HttpMethod.GET, "/produto/id/{id}").permitAll()
//                .antMatchers(HttpMethod.GET, "/imagem").permitAll()
//                .antMatchers(HttpMethod.GET, "/imagem/produto/{id}").permitAll()
//                .antMatchers(HttpMethod.GET, "/categoria").permitAll()
//                .antMatchers(HttpMethod.GET, "/cidade").permitAll()
//                .antMatchers(HttpMethod.GET, "/reserva/{id}").permitAll()
//                .antMatchers(HttpMethod.GET, "/detalhes").permitAll()
//                .antMatchers(HttpMethod.GET, "/reserva").permitAll()
               // .antMatchers("/**").hasRole(String.valueOf(Funcao.ADMIN))
                //.antMatchers("/carro").hasRole(String.valueOf(Funcao.CLIENTE))
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
