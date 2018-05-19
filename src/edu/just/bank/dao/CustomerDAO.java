package edu.just.bank.dao;

import java.util.Set;

import edu.just.bank.domain.Customer;

public interface CustomerDAO {

	public abstract Customer getCustomer(int userId);
	
	public abstract void addCustomer(Customer customer, int userId);
	
	public abstract Set<Customer> getCustomersWithUserId(Integer userId);

}