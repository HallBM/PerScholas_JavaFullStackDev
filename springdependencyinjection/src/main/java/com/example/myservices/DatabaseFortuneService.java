package com.example.myservices;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements IFortuneServices {

  @Override
  public String getFortune() {
     // TODO Auto-generated method stub
     return "Database connection";
  }
}
