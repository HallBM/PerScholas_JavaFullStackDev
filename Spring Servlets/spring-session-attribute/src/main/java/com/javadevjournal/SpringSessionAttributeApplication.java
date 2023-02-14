package com.javadevjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.javadevjournal.*" })
public class SpringSessionAttributeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionAttributeApplication.class, args);
    }
}
