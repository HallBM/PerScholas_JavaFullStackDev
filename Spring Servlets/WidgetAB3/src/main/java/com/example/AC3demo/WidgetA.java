package com.example.AC3demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WidgetA {
	@Autowired
	private WidgetB b;



	public String doSomething() {
		return ("CALLED doSomething() in WidgetA");
	}

}