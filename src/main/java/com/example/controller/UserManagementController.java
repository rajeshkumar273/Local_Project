package com.example.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDetailsRequestDto;
import com.example.entity.UserDetails;
import com.example.service.UserManagementService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserManagementController {
	
	@Autowired
	UserManagementService userManagementService;
	
	
	@PostMapping(path="/user/create" ,
			consumes = MediaType.APPLICATION_JSON_VALUE , 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> userRegistration(@RequestBody UserDetailsRequestDto userDetails ) {
		
		System.out.println("Recived Request Data :"+userDetails);
		//System.out.println("Recived Request Data :"+userDetails.getContact());  //setter and getter
		// TODO: Service, Layer -> Repository layer -> DB
	
		
		
		String results= userManagementService.userRegistration(userDetails);
		
		if(results!=null) {
			//inserted
			//201 Created
			//User Registration completed successful, Try Login Now. 
			
			//return new ResponseEntity<>(results,HttpStatusCode.valueOf(201));  // interface
			return new ResponseEntity<String>(results, HttpStatus.CREATED);      //Enum
		}
		
		else {
			// not inserted.
			// 200 Ok
			//Email existed, Please Try with New One.
			
			return new ResponseEntity<String>("Email existed, Please Try with New One.",HttpStatus.OK);
		}
		
	
	}

	/*
	
	@PostMapping(path="/user/create/address" ,
			consumes = MediaType.APPLICATION_JSON_VALUE , 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String userRegistrationWithAddress(@RequestBody UserDetailsRequestV2 userDetailswithadress ) {
		
		System.out.println("Recived Request Data :"+userDetailswithadress);
		//System.out.println("Recived Request Data :"+userDetails.getContact());  //setter and getter
		// TODO: Service, Layer -> Repository layer -> DB
	
		return addressService.userRegistrationWithAddress(userDetailswithadress);
	}
	*/
	
	@GetMapping(path = "/user/{emailId}") 
	public UserDetails getUserInformationByEmail(@PathVariable("emailId") String email) {
		System.out.println("Email id received for information:"+email);
		
		return userManagementService.getUserInformationByEmail(email);
	}
	
	
	// Get users information based on City and Gender:
	@GetMapping(path = "users/{city}/{gender}")
	public List<UserDetails> getUsersByCityAndGender(
			@PathVariable(name ="city") String cityName, 
			@PathVariable String gender) {
		
		System.out.println("Fetching User Information by Gender:"+gender+ ",city:"+cityName);
		
		return userManagementService.getUsersByCityAndGender(cityName,gender);
	}
	
	@DeleteMapping(path = "/user/{city}")
	public String deleteUsersByCity(@PathVariable String city) {
		
		System.out.println("Deleting user infomation by city:"+city);
		
		return userManagementService.deleteUsersByCity(city);
	}
	
	//Req: Get users Information based in city and gender
	
	//REST Service
	
	//Query Parameters / Query String
	
	//PATH variables @GetMapping(path ="/users/info/{city}/{gender}")
	
	//Request parameter and Query parameter both are same. 
	
	//Spring Web internally: /users/info?city=hyd & gender=male
	
	@GetMapping(path= "/users/info")
	public List<UserDetails> getUsersInfoByCityAndGender(
			@RequestParam String city,
			@RequestParam(name="gender") String genderValue) {
		
		System.out.println("Fetching User Information by Gender:"+genderValue+ ",city:"+city);
		
		return userManagementService.getUsersByCityAndGender(city,genderValue);
		
	}
	
	
	//Req : Get Users based on city always
	// if gender is presented get Data city and gender
	// if gender is not presented get Data city
	//By default @RequestParam is requried, that's why we are making it as false. 
	@GetMapping(path="/users/info/{city}")
	public List<UserDetails> getUsersInfoByCity(@RequestParam(required = false) String gender, @PathVariable String city) {
		
		System.out.println("Fetching User Information by Gender:"+gender+ ",city:"+city);
		
		if(gender!=null)
		return userManagementService.getUsersByCityAndGender(city,gender);
		else {
			return userManagementService.getUsersByCity(city);	
		}
		
		/*
		 *  if(gender.equalsIngoreCase("MALE") && (gender.equalsIngoreCase("FEMALE")) {
		 *  
		 *  	return userManagementService.getUsersByCityAndGender(city,gender)
		 *  
		 *  }
		 *  
		 *  return null;
		 *  
		 * 
		 */
		
		
	}
	
}
