package com.example.moviedetailapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.example.*")
public class MovieDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDetailApplication.class, args);
	}

}
