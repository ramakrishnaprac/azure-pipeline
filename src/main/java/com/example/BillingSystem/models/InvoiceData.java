package com.example.BillingSystem.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "invoice_data")
public class InvoiceData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "customer_Id")
	private long customerId;
	
	@Temporal(TemporalType.DATE)
	private Date paymentDueDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_fk_id", referencedColumnName = "id")
	private List<Item> itemsList = new ArrayList<>();
	
	@Column(name = "total_amount")
	private float totalAmount;
	
	@Column(name = "total_number_of_items")
	private float totalNumberOfItems;
	
	public InvoiceData() {
		
	}
	public InvoiceData(long customerId, Date paymentDueDate, float totalAmount, float totalNumberOfItems) {
		super();
		this.customerId = customerId;
		this.paymentDueDate = paymentDueDate;
		this.totalAmount = totalAmount;
		this.totalNumberOfItems = totalNumberOfItems;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public Date getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	public List<Item> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public float getTotalNumberOfItems() {
		return totalNumberOfItems;
	}
	public void setTotalNumberOfItems(float totalNumberOfItems) {
		this.totalNumberOfItems = totalNumberOfItems;
	}
	
}
