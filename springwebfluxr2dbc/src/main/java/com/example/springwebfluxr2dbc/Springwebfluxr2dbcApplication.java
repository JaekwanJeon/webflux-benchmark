package com.example.springwebfluxr2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@EnableWebFlux
@SpringBootApplication
public class Springwebfluxr2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springwebfluxr2dbcApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		return WebClient.create();
	}
}
