package com.spring_sercurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringSercurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSercurityApplication.class, args);
	}

}
