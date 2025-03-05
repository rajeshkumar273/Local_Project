package com.example.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsDto {

	
	//@Min(value = 5, message = "Name Should Contains Minimum 5 characters")
	//@Max(value = 10, message = "Name Should contain maximum 50 characters")
	
	@Size(min = 5, max = 50)
	// Not null, not empty
	@NotBlank(message = "Name Should Not be Blank and Empty")
	private String name;
	
	@NotBlank
	@Email(message = "Email is invalid Format")
	private String email;
	
	@NotBlank(message = "Password Should Not be Blank and Empty")
	private String password;
	
	//@Pattern(regexp = )
	private long contact;
	
	private String gender;
	private String city;
	
}
