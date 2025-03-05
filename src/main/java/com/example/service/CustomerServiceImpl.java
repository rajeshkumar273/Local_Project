package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerDetailsDto;
import com.example.entity.CustomerDetails;
import com.example.repository.CustomerManagementReposity;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerManagementReposity customerManagementReposity;
	
	@Override
	public String customerRegistration(CustomerDetailsDto customerDetailsDto) {
		
		
		//Create Customer Entity
		CustomerDetails customerData=new CustomerDetails();
		
		customerData.setEmail(customerDetailsDto.getEmail());
		customerData.setName(customerDetailsDto.getName());
		customerData.setPassword(customerDetailsDto.getPassword());
		customerData.setContact(customerDetailsDto.getContact());
		customerData.setGender(customerDetailsDto.getGender());
		customerData.setCity(customerDetailsDto.getCity());
		
		customerData= customerManagementReposity.save(customerData);
		return "Customber Registration successful."+customerData.getEmail();
	}

}
