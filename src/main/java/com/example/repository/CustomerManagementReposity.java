package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.CustomerDetails;

@Repository
public interface CustomerManagementReposity extends JpaRepository<CustomerDetails, String> {

	CustomerDetails save(CustomerDetails customerData);

}
