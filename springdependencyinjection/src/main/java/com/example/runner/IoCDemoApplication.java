package com.example.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.myservices.ICoach;

@SpringBootApplication(scanBasePackages = { "com.example" })
//Note: in above line, "myServices" is a package name
public class IoCDemoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IoCDemoApplication.class, args);

		// get the bean from spring container
		ICoach theCoach = context.getBean(ICoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
	}
}
