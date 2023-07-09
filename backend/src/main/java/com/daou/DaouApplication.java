package com.daou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DaouApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaouApplication.class, args);
	}

}


