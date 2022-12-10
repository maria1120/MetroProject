package com.maria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maria.entity.Customer;
import com.maria.entity.CustomerInvoice;
import com.maria.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao dao;

	
	public Customer getCustomer(int id){
		 return dao.findById(id).get();
	
	}
	
	public Customer addCustomer(Customer customer) {
		if(getCustomer(customer.getCustomerId()) != null) {
			return null;
		}
		else {
			dao.save(customer);
			return customer;
		}
	}
	
	
	
	public Customer deductBalance(int id, double amount) {
		Customer nCustomer =getCustomer(id); 
			if(nCustomer !=null) {
				nCustomer.setCustomerBalance(nCustomer.getCustomerBalance()-amount);
				return nCustomer;
			}
			return null;
		
	}
	public Customer topUpbalance(int id, double amount) {
		Customer theCustomer = getCustomer(id);
		if(theCustomer !=null) {
			theCustomer.setCustomerBalance(theCustomer.getCustomerBalance()+amount);
			return theCustomer;
		}
		return null;
	}
	
	public Customer setStationToNull(int id) {
		Customer customer = getCustomer(id);
		if(customer !=null) {
			customer.setStationId(0);
			return customer;
		}
		return null;
	}
	
	public List<CustomerInvoice> getCustomerInvoices(int customerId){
		return dao.getInvoicesByCustomerId(customerId);
	}
}
