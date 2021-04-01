package com.example.BillingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDataRequest {

	private String orgAdress;
	private String customerAdress;
	private String customerMobile;
	private List<Item> items = new ArrayList<>();
	private String paymentDueDate;
	private String totalItems;
	private String calculatedTotalAmount;
	private String customerName;
	
	
	public String getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(String totalItems) {
		this.totalItems = totalItems;
	}
	public String getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	public String getOrgAdress() {
		return orgAdress;
	}
	public void setOrgAdress(String orgAdress) {
		this.orgAdress = orgAdress;
	}
	public String getCustomerAdress() {
		return customerAdress;
	}
	public void setCustomerAdress(String customerAdress) {
		this.customerAdress = customerAdress;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public String getCalculatedTotalAmount() {
		return calculatedTotalAmount;
	}
	public void setCalculatedTotalAmount(String calculatedTotalAmount) {
		this.calculatedTotalAmount = calculatedTotalAmount;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}
