package edu.just.bank.dao;

import java.util.Set;

import edu.just.bank.domain.Customer;

public interface CustomerDAO {

	public abstract Customer getCustomer(int accountId);
	
	public abstract Set<Customer> getCustomersWithAccountId(Integer accountId);

}