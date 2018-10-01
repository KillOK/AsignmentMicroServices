package com.killok.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.killok.library")
public class LibraryMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMicroServiceApplication.class, args);
	}
}
