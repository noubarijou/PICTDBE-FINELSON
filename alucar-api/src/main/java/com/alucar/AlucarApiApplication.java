package com.alucar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class}) // "exclude...." -> retira a obrigatoriedade de inserir senha para acessar a api
public class AlucarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlucarApiApplication.class, args);
	}



//	@Bean //compomente para encriptamento de senha.
//	public PasswordEncoder getPasswordEncoder() {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}

}
