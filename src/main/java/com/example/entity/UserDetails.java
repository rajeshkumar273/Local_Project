package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="flip_user_details")
public class UserDetails {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Integer userId;
	private String email;
	private String name;
	private String password;
	private long contact;
	private String city;
	private String gender;

}
