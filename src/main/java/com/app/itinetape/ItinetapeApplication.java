package com.app.itinetape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class ItinetapeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItinetapeApplication.class, args);
	}

}
