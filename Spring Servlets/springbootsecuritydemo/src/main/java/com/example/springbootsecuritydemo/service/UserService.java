package com.example.springbootsecuritydemo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.springbootsecuritydemo.DTO.UserRegistrationDTO;
import com.example.springbootsecuritydemo.model.User;

public interface UserService extends UserDetailsService {
   User findByEmail(String email);
   User save(UserRegistrationDTO registration);
}

