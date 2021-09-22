package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "com.lt.*")
@EnableWebMvc
@Configuration
@SpringBootApplication
public class CrsRestPosDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsRestPosDevelopmentApplication.class, args);
	}

}
