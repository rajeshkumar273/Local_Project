package com.example.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CandidateDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CandidateManagamentController {
	
	private String hostname;

	@PostMapping(path = "/candidate/login")
	public ResponseEntity<String> candidateLogin(@RequestBody CandidateDto candidateData ,
			@RequestHeader(name="hostname") String hostname) {
		
		this.hostname = hostname;
		System.out.println("Request Came from Host :"+hostname);
		
		System.out.println("Data :"+candidateData);
		
		String token = "dkkkkkkkkkkkkkkkkkkkkkaaaaaaaaaaaaaaaaaakkkkkkkkkk";
		
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("secret_key", token);
		
		ResponseEntity<String> response= new ResponseEntity<String>("User Login Successful",responseHeaders, HttpStatus.OK);
		
		return response;
		
	
		
	}

}
