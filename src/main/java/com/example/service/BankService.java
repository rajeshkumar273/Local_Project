package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class BankService {
	
	
	Logger logger = LoggerFactory.getLogger(BankService.class);
	
public String transfer(String user) {
	
		
		logger.info("Ammount traffering from "+user+ " Account");
		logger.info("Amount transfered from 123 to 143....");
		
		return "Transfer Completed Successfully";
	}

}
