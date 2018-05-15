package edu.just.bank.test;

import java.util.Set;

import org.junit.jupiter.api.Test;

import edu.just.bank.dao.CustomerDAO;
import edu.just.bank.dao.impl.CustomerDAOImpl;
import edu.just.bank.domain.Customer;

class CustomerDAOTest {

	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	@Test
	void testGetCustomer() {
		Customer customer = customerDAO.getCustomer(5);
		System.out.println(customer);
	}

	@Test
	void testGetCustomersWithAccountId() {
		Set<Customer> customers = customerDAO.getCustomersWithAccountId(5);
		System.out.println(customers);
	}

}
