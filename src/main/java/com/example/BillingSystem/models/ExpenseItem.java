package com.example.BillingSystem.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "expense_items")
public class ExpenseItem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "expense_date")
	private Date expenseDate;
	
	@Column(name = "expense_name")
	private String name;
	
	@Column(name = "expense_category")
	private String category;
	
	@Column(name = "quantity_count")
	private int quantity;
	
	@Column(name = "total_amount")
	private float totalAmount;

	public ExpenseItem() {
		
	}
	
	public ExpenseItem(Date expenseDate, String name, String category, int quantity, float totalAmount) {
		super();
		this.expenseDate = expenseDate;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
