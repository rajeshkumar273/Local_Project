package com.example.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BankCustomer;
import com.example.service.BankService;

@RestController
public class BankController {
	
	
	@Autowired
	BankService bankService;
	
	Logger logger= LoggerFactory.getLogger(BankController.class);

	
	@PostMapping("/bank/login")
	public ResponseEntity<String> userRegistration(@RequestBody BankCustomer customerDetails) {
		
		logger.info("Bank Login Recived Request data: "+customerDetails);
		logger.error("Bank Login Recived Request data: "+customerDetails);
		logger.warn("Bank Login Recived Request data: "+customerDetails);
		logger.debug("Bank Login Recived Request data: "+customerDetails);
		logger.trace("Bank Login Recived Request data: "+customerDetails);
	
		
		//bankService.transfer(customerDetails.getEmail());
		
		//TODO: Service Layer -> Resposity Layer
		
		return new ResponseEntity<String> ("Login and Transfer Completed", HttpStatus.CREATED);
		
	}

	

}
