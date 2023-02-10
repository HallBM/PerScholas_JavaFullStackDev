package com.example.thymeleafformdemo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginPOJO implements Serializable {
		
	    private String uname;
	    private String password;
}
