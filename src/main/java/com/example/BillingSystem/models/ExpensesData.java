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
@Table(name = "expenses_data")
public class ExpensesData {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "from_date")
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "to_date")
	private Date toDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "expense_fk_id", referencedColumnName = "id")
	private List<ExpenseItem> expenses = new ArrayList<>();
	
	
	@Column(name = "total_expenses_count")
	private float totalExpensesCount;
	
	@Column(name = "total_expenses_amount")
	private float calculatedTotalAmount;

	public ExpensesData() {
		
	}
	
	public ExpensesData(Date fromDate, Date toDate, List<ExpenseItem> expenses, float totalExpensesCount,
			float calculatedTotalAmount) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.expenses = expenses;
		this.totalExpensesCount = totalExpensesCount;
		this.calculatedTotalAmount = calculatedTotalAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public List<ExpenseItem> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<ExpenseItem> expenses) {
		this.expenses = expenses;
	}

	public float getTotalExpensesCount() {
		return totalExpensesCount;
	}

	public void setTotalExpensesCount(float totalExpensesCount) {
		this.totalExpensesCount = totalExpensesCount;
	}

	public float getCalculatedTotalAmount() {
		return calculatedTotalAmount;
	}

	public void setCalculatedTotalAmount(float calculatedTotalAmount) {
		this.calculatedTotalAmount = calculatedTotalAmount;
	}
	
	
}
