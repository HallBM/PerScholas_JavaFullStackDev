package com.example.AC3demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Ac3demoApplication {

	public static void main(String[] args) {

    ConfigurableApplicationContext context =  SpringApplication.run(Ac3demoApplication.class, args);

    // get the bean from spring container
    //YOUR_CODE_HERE
    WidgetA di_wid = context.getBean(WidgetA.class);
    
    // old way, tight coupling
    //WidgetA wid = new WidgetA();
    
    // call a method on the bean
    System.out.println("\nMethod call:");
    System.out.println(di_wid.doSomething());
 
    // close the context
    context.close();
    
	}
}