package com.example.BillingSystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_data")
public class CustomerData {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_mobile")
	private String customerMobile;
	
	@Column(name = "customer_adress")
	private String customerAdress;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerAdress() {
		return customerAdress;
	}
	public void setCustomerAdress(String customerAdress) {
		this.customerAdress = customerAdress;
	}
	
	
	
}
