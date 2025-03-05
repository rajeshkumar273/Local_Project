package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDetailsRequestDto {
	
	private String name;
	private String email;
	private String password;
	private long contact;
	private String city;
	private String gender;

}
