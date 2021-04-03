package com.example.BillingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BillingSystem.models.CustomerData;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerData, Long>{

	CustomerData findByCustomerMobile(String customerMobile);
	
}
