package com.maria.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maria.entity.Customer;
import com.maria.entity.CustomerInvoice;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public List<CustomerInvoice>getInvoicesByCustomerId(int customerId);
}
