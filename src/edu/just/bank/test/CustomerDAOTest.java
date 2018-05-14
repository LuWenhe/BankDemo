package edu.just.bank.test;

import org.junit.jupiter.api.Test;

import edu.just.bank.dao.CustomerDAO;
import edu.just.bank.dao.impl.CustomerDAOImpl;
import edu.just.bank.domain.Customer;

class CustomerDAOTest {

	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	@Test
	void testGetCustomer() {
		Customer customer = customerDAO.getCustomer1(3);
		System.out.println(customer.getBalance());
	}

}
