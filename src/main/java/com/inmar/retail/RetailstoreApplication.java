package com.inmar.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RetailstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(RetailstoreApplication.class, args);
	}
}
