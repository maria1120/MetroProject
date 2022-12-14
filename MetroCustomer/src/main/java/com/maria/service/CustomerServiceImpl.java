package com.maria.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maria.entity.Customer;
import com.maria.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao dao;

	
	public Customer getCustomer(int id){
		 return dao.findById(id).orElse(null);
	
	}
	@Override
	public List<Customer> getAllCustomers() {
		 List<Customer>listAll = dao.findAll();
		return listAll;
	}

	
	public Customer addCustomer(Customer customer) {
		// Find Customer Date of Birth
		LocalDate dob = customer.getCustomerDateOfBirth();
		
		// Get current date
		LocalDate curDate = LocalDate.now();  
		
		// Calculate customer age, if over 11, create customer
		if (Period.between(dob, curDate).getYears() >= 11) {
			
			// Save new Customer and add £25 to account
			customer.setCustomerBalance(25);
			dao.save(customer);
			return customer;
		}
		
		return null;
	}

	
	public Customer deleteCustomer(int id) {
		Customer customer = getCustomer(id);
		if(customer !=null) {
			dao.delete(customer);
			return customer;
		}
		return null;
	}

	
	public Customer deductBalance(int id, double amount) {
		Customer nCustomer =getCustomer(id); 
			if(nCustomer !=null) {
				nCustomer.setCustomerBalance(nCustomer.getCustomerBalance()-amount);
				dao.save(nCustomer);
				return nCustomer;
			}
			return null;
		
	}
	public Customer topUpbalance(int id, double amount) {
		Customer theCustomer = getCustomer(id);
		if(theCustomer !=null) {
			theCustomer.setCustomerBalance(theCustomer.getCustomerBalance()+amount);
			 dao.save(theCustomer);
			 return theCustomer;
			
			
		}
		return null;
	}
	
	public Customer setStationIdToCustomer(int id, int stationId) {
		Customer customer = getCustomer(id);
		if(customer !=null) {
			customer.setStationId(stationId);
			 dao.save(customer);
			 return customer;
		}
		return null;
	}
	
	



	
}
