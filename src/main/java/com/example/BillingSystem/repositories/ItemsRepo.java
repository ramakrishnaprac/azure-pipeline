package com.example.BillingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BillingSystem.models.Item;

@Repository
public interface ItemsRepo extends JpaRepository<Item, Long>{

	
	
	
}
