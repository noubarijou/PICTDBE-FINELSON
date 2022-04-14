package com.alucar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // (exclude = {SecurityAutoConfiguration.class}) // "exclude...." -> retira a obrigatoriedade de inserir senha para acessar a api
public class AlucarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlucarApiApplication.class, args);
	}
}
