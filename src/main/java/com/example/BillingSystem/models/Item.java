package com.example.BillingSystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_data")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name="item_quantity")
	private int itemQuantity;
	
	@Column(name = "unit_price")
	private float unitPrice;
	
	@Column(name = "total_amount")
	private float totalAmount;
	
	public Item() {
		
	}
	
	public Item(String itemName, int itemQuantity, float unitPrice, float totalAmount) {
		super();
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.unitPrice = unitPrice;
		this.totalAmount = totalAmount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
