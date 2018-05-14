package edu.just.bank.dao;

import edu.just.bank.domain.Customer;

public interface CustomerDAO {

	public abstract Customer getCustomer(int userId);
	
	public abstract Customer getCustomer1(int accountId);
	
}