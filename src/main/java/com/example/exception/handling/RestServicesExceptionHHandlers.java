package com.example.exception.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestServicesExceptionHHandlers {
	
	//ArithmeticException
	
	@ExceptionHandler(ArithmeticException.class) 
	@ResponseBody
	public ResponseEntity<String> handleArthmeticException(ArithmeticException ex, HttpServletRequest request) {
		
		System.out.println(ex.getMessage());
		System.out.println(request.getContextPath());
		System.out.println(request.getPathInfo());
		
		return new ResponseEntity<String>("Please check values, Values should not be Zero", HttpStatus.BAD_REQUEST) ;
		
		//HttpStatus.BAD_REQUEST
		//HttpStatus.INTERNAL_SERVER_ERROR
	}
	
	
	//Null Pointer Exception
	
	/*
	
	@ExceptionHandler(NullPointerException.class) 
	@ResponseBody
	public ResponseEntity<String> handleNUllException(NullPointerException exx, HttpServletRequest request) {
		
		System.out.println(exx.getMessage());
		System.out.println(request.getContextPath());
		System.out.println(request.getPathInfo());
		
		return new ResponseEntity<String>("Value is null", HttpStatus.BAD_REQUEST) ;
		
	}
	
	*/
	
	/*

	@ExceptionHandler(Exception.class)   //Parent Exception generic errors
	@ResponseBody
	public ResponseEntity<String> handleNUllException(Exception exx, HttpServletRequest request) {
		
		System.out.println(exx.getMessage());
		System.out.println(request.getContextPath());
		System.out.println(request.getPathInfo());
		
		return new ResponseEntity<String>("Please check the data, We are getting Exceptions", HttpStatus.BAD_REQUEST) ;
		
	}
	
	*/

	
	@ExceptionHandler(MethodArgumentNotValidException.class)   //Parent Exception generic errors
	@ResponseBody
	public ResponseEntity<String> handleNUllException(MethodArgumentNotValidException exx, HttpServletRequest request) {
		
		System.out.println(exx.getMessage());
		System.out.println(request.getContextPath());
		System.out.println(request.getPathInfo());
		
		return new ResponseEntity<String>("Please enter all mendatory fields", HttpStatus.BAD_REQUEST) ;
		
		
		
	}
	
	//Method ArgumentNotValidException
	
	

}
