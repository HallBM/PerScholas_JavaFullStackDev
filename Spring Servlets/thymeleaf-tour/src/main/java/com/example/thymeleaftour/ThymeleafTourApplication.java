package com.example.thymeleaftour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.example.*"})
public class ThymeleafTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafTourApplication.class, args);
	}

}
