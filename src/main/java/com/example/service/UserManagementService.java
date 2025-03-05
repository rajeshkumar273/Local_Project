package com.example.service;

import java.util.List;

import com.example.dto.UserDetailsRequestDto;
import com.example.entity.UserDetails;


public interface UserManagementService {
	
	
	
	String userRegistration(UserDetailsRequestDto userDetailsRequestDto);

	UserDetails getUserInformationByEmail(String email);

	List<UserDetails> getUsersByCityAndGender(String cityName, String gender);

	String deleteUsersByCity(String city);
	
	List<UserDetails> getUsersByCity(String city);

	

}
