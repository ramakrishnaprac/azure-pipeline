package com.example.BillingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BillingSystem.models.ExpenseItem;

@Repository
public interface ExpensesItemRepo extends JpaRepository<ExpenseItem, Long>{

}
