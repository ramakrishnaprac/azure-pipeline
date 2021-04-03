package com.example.BillingSystem.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.BillingSystem.models.InvoiceData;

@Repository
public interface InvoiceRepo extends JpaRepository<InvoiceData, Long>{

	
	/*@Query("select a from InvoiceData a where a.paymentDueDate between '2021-3-1' and '2021-3-30'")
    List<InvoiceData> findAllWithPaymentDueDateBetween(
      );*/
	
	List<InvoiceData> findAllByPaymentDueDateBetween(
		      Date paymentDueDateStart,
		      Date paymentDueDateEnd);
	
}
