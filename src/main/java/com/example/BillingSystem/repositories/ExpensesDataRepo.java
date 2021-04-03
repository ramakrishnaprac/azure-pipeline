package com.example.BillingSystem.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.BillingSystem.models.ExpensesData;


@Repository
public interface ExpensesDataRepo extends JpaRepository<ExpensesData, Long>{

	
	@Query("select u from ExpensesData u where u.fromDate >= :fromDate or u.toDate <= :toDate")
	List<ExpensesData> findAllByFromDateAndToDate(@Param("fromDate") Date fromDate,
			@Param("toDate") Date toDate);
	
}
