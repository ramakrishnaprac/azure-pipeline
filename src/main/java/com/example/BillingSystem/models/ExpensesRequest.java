package com.example.BillingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class ExpensesRequest {

	/*fromDate: string;
  toDate: string;
  expenses: Expense[];
  totalExpenses : number;
  calculatedTotalAmount : number;*/
	
	private String fromDate;
	private String toDate;
	private List<ExpenseItemRequest> expenses = new ArrayList<>();
	private float totalExpenses;
	private float calculatedTotalAmount;
	
	
	public List<ExpenseItemRequest> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<ExpenseItemRequest> expenses) {
		this.expenses = expenses;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	public float getTotalExpenses() {
		return totalExpenses;
	}
	public void setTotalExpenses(float totalExpenses) {
		this.totalExpenses = totalExpenses;
	}
	public float getCalculatedTotalAmount() {
		return calculatedTotalAmount;
	}
	public void setCalculatedTotalAmount(float calculatedTotalAmount) {
		this.calculatedTotalAmount = calculatedTotalAmount;
	}
	
	
	
}
