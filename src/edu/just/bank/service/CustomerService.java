package edu.just.bank.service;

import edu.just.bank.dao.CustomerDAO;
import edu.just.bank.dao.impl.CustomerDAOImpl;
import edu.just.bank.domain.ALoan;
import edu.just.bank.domain.Customer;

public class CustomerService {

	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public Customer getCustmerWithUserId(int userId) {
		return customerDAO.getCustomer(userId);
	}
	
	public Customer getCustomerWithCustomerId(int customerId) {
		return customerDAO.getCustomer1(customerId);
	}
	
	public void addCustomer(Customer customer, int userId) {
		customerDAO.addCustomer(customer, userId);
	}
	
	public void updateCustomer(int customerId, ALoan aLoan) {
		customerDAO.updateCustomer(customerId, aLoan);
	}
}
