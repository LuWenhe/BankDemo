package edu.just.bank.service;

import edu.just.bank.dao.CustomerDAO;
import edu.just.bank.dao.impl.CustomerDAOImpl;
import edu.just.bank.domain.Customer;

public class CustomerService {

	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public Customer getCustomerWithUserId(int userId) {
		return customerDAO.getCustomer(userId);
	}
	
	public Customer getCustmerWithAccountId(int accountId) {
		return customerDAO.getCustomer1(accountId);
	}
	
}
