 package com.example.thymeleafformdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationPOJO {

	private String fname;
    private String lname;
    private String dob;
    private String phoneno;
    private String jobtitle;
    private String company;
    
}
