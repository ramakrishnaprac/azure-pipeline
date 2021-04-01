package com.example.BillingSystem.controllers;


import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BillingSystem.models.CustomerData;
import com.example.BillingSystem.models.ExpenseItem;
import com.example.BillingSystem.models.ExpensesData;
import com.example.BillingSystem.models.ExpensesRequest;
import com.example.BillingSystem.models.InvoiceData;
import com.example.BillingSystem.models.InvoiceDataRequest;
import com.example.BillingSystem.models.ReportResponse;
import com.example.BillingSystem.models.TotalExpenses;
import com.example.BillingSystem.repositories.CustomerRepo;
import com.example.BillingSystem.repositories.ExpensesDataRepo;
import com.example.BillingSystem.repositories.ExpensesItemRepo;
import com.example.BillingSystem.repositories.InvoiceRepo;
import com.example.BillingSystem.repositories.ItemsRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class BillingController {

	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	private InvoiceRepo invoicerepo;
	
	@Autowired
	private ItemsRepo itemsRepo;
	
	@Autowired
	private CustomerRepo custRepo;
	
	
	@Autowired
	private ExpensesDataRepo expensesDataRepo;
	
	@Autowired
	private ExpensesItemRepo expensesItemRepo;
	
	
	
	
	@PostMapping(path = "/addExpenses")
	public ExpensesData saveExpenses(@RequestBody ExpensesRequest request) {
		
		ExpensesData expensedata = new ExpensesData();
		
		Date x = new Date();
		Date y= new Date();
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			x = sd.parse(request.getFromDate());
			y = sd.parse(request.getToDate());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		List<ExpenseItem> list = new ArrayList<ExpenseItem>();
		request.getExpenses().forEach((element)->{
			try {
				ExpenseItem sample = new ExpenseItem();
				sample.setCategory(element.getCategory());
				sample.setName(element.getName());
				sample.setQuantity(element.getQuantity());
				sample.setTotalAmount(element.getTotalAmount());
				sample.setExpenseDate(sd.parse(element.getExpenseDate()));
				list.add(sample);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		});
		
		LOGGER.log(Level.INFO, "given items size "+list.size());
		expensedata.setExpenses(list);
		expensedata.setFromDate(x);
		expensedata.setToDate(y);
		expensedata.setCalculatedTotalAmount(request.getCalculatedTotalAmount());
		expensedata.setTotalExpensesCount(request.getTotalExpenses());
		return expensesDataRepo.save(expensedata);
	}
	
	@GetMapping("/getExpenses")
	public List<ExpensesData> getExpenses(){
		
		return expensesDataRepo.findAll();
	}
	
	
	@PostMapping(path = "/addInvoice")
	public InvoiceData saveInvoice(@RequestBody InvoiceDataRequest request) throws ParseException {
		
		
		long custId;
		CustomerData result = this.custRepo.findByCustomerMobile(request.getCustomerMobile());
		
		if(result != null) {
			custId = result.getId();
		}
		else {
			
			CustomerData customer = new CustomerData();
			customer.setCustomerAdress(request.getCustomerAdress());
			customer.setCustomerMobile(request.getCustomerMobile());
			customer.setCustomerName(request.getCustomerName());
			
			result = this.custRepo.save(customer);
			custId = result.getId();
		}
		
		
		InvoiceData invData = new InvoiceData();
		invData.setCustomerId(custId);
		LOGGER.log(Level.INFO, "given items size "+request.getItems().size());
		invData.setItemsList(request.getItems());
		Date bookingDate = null;
		LOGGER.log(Level.INFO, "given Date "+request.getPaymentDueDate());
		try {
			if(!request.getPaymentDueDate().isEmpty()) {
			bookingDate =new SimpleDateFormat("dd/MM/yyyy").parse(request.getPaymentDueDate());
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		invData.setPaymentDueDate(bookingDate);
		invData.setTotalAmount(Long.parseLong(request.getCalculatedTotalAmount()));
		invData.setTotalNumberOfItems(Long.parseLong(request.getTotalItems()));
		
		return this.invoicerepo.save(invData);
	}
	
	@GetMapping(path = "/getInvoices")
	public List<InvoiceData> fetchInvoices(){
		
		List<InvoiceData> list = new ArrayList<InvoiceData>();
		Date x = new Date();
		Date y = new Date();
		try {
			x = new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-01");
			y = new SimpleDateFormat("yyyy/MM/dd").parse("2021/04/30");
		}
		catch(Exception s) {
			s.printStackTrace();
		}
		LOGGER.log(Level.INFO, "given Date in custom format x "+x);
		LOGGER.log(Level.INFO, "given Date in custom format y "+y);
		list = this.invoicerepo.findAllByPaymentDueDateBetween(x, y);
		LOGGER.log(Level.INFO, "size of list" +list.size());
		return this.invoicerepo.findAll();
		
	}
	
	float totalexpenses = 0;
	float totalInvoicesBill = 0;
	
	@GetMapping(path = "/fetchReport")
	public ReportResponse fetchReport(@RequestParam String fromDate, @RequestParam String toDate , @RequestParam String month) {
		
		this.totalexpenses = 0;
		this.totalInvoicesBill = 0;
		
		Map<String, String> monthsMap = new HashMap<String, String>();
		monthsMap.put("01", "January");
		monthsMap.put("02", "Febraury");
		monthsMap.put("03", "March");
		monthsMap.put("04", "April");
		monthsMap.put("05", "May");
		monthsMap.put("06", "June");
		monthsMap.put("07", "July");
		monthsMap.put("08", "August");
		monthsMap.put("09", "Septemebr");
		monthsMap.put("10", "October");
		monthsMap.put("11", "November");
		monthsMap.put("12", "December");
		List<InvoiceData> list1 = new ArrayList<InvoiceData>();
		List<ExpensesData> list2 = new ArrayList<ExpensesData>();
		List<TotalExpenses> report = new ArrayList<TotalExpenses>();
		ReportResponse result = new ReportResponse();
		Date from = new Date();
		Date to = new Date();
		try {
			from = new SimpleDateFormat("yyyy/MM/dd").parse(fromDate);
			to = new SimpleDateFormat("yyyy/MM/dd").parse(toDate);
		}
		catch(Exception s) {
			s.printStackTrace();
		}
		
		list1 = this.invoicerepo.findAllByPaymentDueDateBetween(from, to);
		if(list1.size() > 0) {
			Date p = new Date();
			Date q = new Date();
			try {
				p = new SimpleDateFormat("yyyy/MM/dd").parse(fromDate);
				q = new SimpleDateFormat("yyyy/MM/dd").parse(toDate);
			}
			catch(Exception s) {
				s.printStackTrace();
			}
			
			list2 = expensesDataRepo.findAllByFromDateAndToDate(p, q);
		}
		else {
			
		}
		
		if(list1.size() > 0 && list2.size() > 0) {
			result.setDataPresent("Yes");
		}
		else {
			result.setDataPresent("No");
		}
		
		list1.forEach((element)->{
			
			totalInvoicesBill = totalInvoicesBill + element.getTotalAmount();
		});
		
		list2.forEach((element)->{
			totalexpenses = totalexpenses + element.getCalculatedTotalAmount();
		});
		
		
		
		
		TotalExpenses invoicesdetails = new TotalExpenses();
		TotalExpenses expensesdetails = new TotalExpenses();
		invoicesdetails.setAmount(totalInvoicesBill);
		invoicesdetails.setComponentName("Total goods sold amount");
		expensesdetails.setAmount(totalexpenses);
		expensesdetails.setComponentName("Total Expenses");
		report.add(invoicesdetails);
		report.add(expensesdetails);
		TotalExpenses lossdetails = new TotalExpenses();
		if(totalexpenses > totalInvoicesBill) {
			
			lossdetails.setComponentName("Total Loss");	
			lossdetails.setAmount((totalexpenses-totalInvoicesBill));
					
		}
		else{
			
			lossdetails.setComponentName("Total Profit");	
			lossdetails.setAmount((totalInvoicesBill-totalexpenses));
		}
		if(lossdetails != null) {
			report.add(lossdetails);
		}
		
		result.setList(report);
		result.setMonth(monthsMap.get(month));
		return result;
	
	
	
}
}
