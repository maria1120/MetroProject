package com.maria.service;

import java.util.List;

import com.maria.entity.Customer;
import com.maria.entity.CustomerInvoice;

public interface CustomerService {

	 Customer getCustomer(int id);
	 Customer addCustomer(Customer customer);
	 Customer deductBalance(int id, double amount);
	 Customer topUpbalance(int id, double amount);
	 Customer setStationToNull(int id);
	 List<CustomerInvoice> getCustomerInvoices(int customerId);
	
}
