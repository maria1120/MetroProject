package com.emily.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages="com.emily")
public class MetroClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetroClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
