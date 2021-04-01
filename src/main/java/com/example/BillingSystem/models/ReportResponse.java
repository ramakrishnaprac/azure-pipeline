package com.example.BillingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class ReportResponse {

	private String month;
	private String  dataPresent;
	
	public String getDataPresent() {
		return dataPresent;
	}

	public void setDataPresent(String dataPresent) {
		this.dataPresent = dataPresent;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	private List<TotalExpenses> list = new  ArrayList<TotalExpenses>();

	public List<TotalExpenses> getList() {
		return list;
	}

	public void setList(List<TotalExpenses> list) {
		this.list = list;
	}
	
	
	
	
	
}
