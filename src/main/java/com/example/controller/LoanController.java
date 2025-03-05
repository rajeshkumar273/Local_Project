package com.example.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
	
	@GetMapping (path="/get/emi")
	public int getEMIValue() {
		
		int value1 = 1000;
		int value2= 0;
		
		int response = value1/value2;
		
		return response;
	}
	
	@PostMapping(path="/register/loan")
	public String registerLoan( ) {
	
		String result = null;
		
		System.out.println(result.length());
		
		return result;	
	}

	
	
}
