package com.example.myservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class TennisCoach implements ICoach {

	@Autowired
	@Qualifier("databaseFortuneService")
	private IFortuneServices fortuneService;
	
	public TennisCoach() {
	}

	public TennisCoach(IFortuneServices theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
