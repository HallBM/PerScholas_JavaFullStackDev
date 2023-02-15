package com.example.AC3demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// When we apply @Component annotation in a Java class, it is 
// considered as a Spring Bean by the Spring Container. However, 
// there are many other annotations that can do the same job, but 
// the @Component is the basic and the most widely used by the developers. 

@Configuration
public class WidgetB {
    @Bean
    void doSomething() {
        System.out.println("\nWidgetB method call:");
        System.out.println("CALLED doSomething() in WidgetB");
    }

}