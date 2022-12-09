package com.maria.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maria.entity.Customer;
import com.maria.entity.ListInvoices;
import com.maria.service.CustomerService;

@RestController
public class CustomerResource {

	@Autowired
	private CustomerService service;

	//get all customers
	@GetMapping(path = "customers/{cId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerById(@PathVariable("cId") int id) {

		return service.getCustomer(id);
	}

	//add new customer
	@PostMapping(path = "customers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer addNewCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);

	}
	//update customer balance after deduction
	@PutMapping(path = "customers/{cId}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer deductFromCustomerBalance(@PathVariable ("cId") int id, @PathVariable("amount") double amount) {
		return service.deductBalance(id,amount);

	}
	
	//update customer balance after top up
	@PutMapping(path = "customers/{cId}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer topUpBalance(@PathVariable("cID") int id, @PathVariable("amount") double amount) {
		return service.topUpbalance(id, amount);
	}
	
	//update customer's starting point to 0 when the journey end
	@PutMapping(path = "customers/{cId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer setStationIdToNull(@PathVariable("cId") int id) {
		return service.setStationToNull(id);
	}
	//get all invoices by customer id
	@GetMapping(path="customers/{cId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ListInvoices getInvoicesByCustomerId(@PathVariable ("cId") int id){
		ListInvoices listInvoices = service.getCustomerInvoices(id);
	}

}
