package com.example.myservices;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements IFortuneServices {
	  @Override
	  public String getFortune() {
	     return "Today is your lucky day!";
	  }

}
