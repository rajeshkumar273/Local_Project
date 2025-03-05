package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CustomerDetailsDto;
import com.example.service.CustomerService;

import jakarta.validation.Valid;




@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(path="/customer/create")
	public String customerRegistration(@Valid @RequestBody CustomerDetailsDto customerDetails ) {
		
		System.out.println("Recived Request Data :"+customerDetails);
		
		return customerService.customerRegistration(customerDetails);
		
		//return new ResponseEntity<String> ("Customer created",HttpStatus.CREATED);
		
	}

}
