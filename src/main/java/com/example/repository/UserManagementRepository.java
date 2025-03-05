package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.UserDetails;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserManagementRepository extends JpaRepository<UserDetails,String> {

	UserDetails findByEmail(String email);

	List<UserDetails> findByCityAndGender(String cityName, String gender);

	int deleteByCity(String city);

	List<UserDetails> findByCity(String city);
		
}
