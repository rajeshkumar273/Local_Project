package com.example.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDetailsRequestDto;
import com.example.entity.UserDetails;
import com.example.repository.UserManagementRepository;



@Service
public class UserManagementServiceImpl implements UserManagementService {
	
	@Autowired
	UserManagementRepository userManagementRepository;
	
	@Override
	public String userRegistration(UserDetailsRequestDto dto) {
		
		
		//FindBy: dto.getEmail
	
		Optional<UserDetails> userDetails=userManagementRepository.findById(dto.getEmail());
		if(userDetails.isPresent()) {
			
			return null;
		}
		
		else {
		//Create Entity object
		UserDetails userData = new UserDetails();
		userData.setContact(dto.getContact());
		userData.setEmail(dto.getEmail());
		userData.setName(dto.getName());
		userData.setPassword(dto.getPassword());
		userData.setCity(dto.getCity());
		userData.setGender(dto.getGender());
		
		
		userData= userManagementRepository.save(userData);
		
		return "User Registration success. This is your ID: "+userData.getEmail();
		}
	}

	@Override
	public UserDetails getUserInformationByEmail(String email) {
		
		return userManagementRepository.findByEmail(email);
	}

	@Override
	public List<UserDetails> getUsersByCityAndGender(String cityName, String gender) {
		
		
		
		return userManagementRepository.findByCityAndGender(cityName,gender);   
		
	}

	@Override
	public String deleteUsersByCity(String city) {
	
				userManagementRepository.deleteByCity(city);
				
				return "Deleted Users successfully";
	}

	@Override
	public List<UserDetails>getUsersByCity(String city) {
		
		return userManagementRepository.findByCity(city);
	}


}
