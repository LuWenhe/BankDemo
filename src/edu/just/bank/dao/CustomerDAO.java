package edu.just.bank.dao;

import java.util.Set;

import edu.just.bank.domain.ALoan;
import edu.just.bank.domain.Customer;

public interface CustomerDAO {

	public abstract Customer getCustomer(Integer userId);
	
	public abstract void addCustomer(Customer customer, Integer userId);
	
	public abstract void updateCustomer(Integer customerId, ALoan aLoan);
	
	public abstract Set<Customer> getCustomersWithUserId(Integer userId);

}