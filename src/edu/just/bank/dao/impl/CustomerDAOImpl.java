package edu.just.bank.dao.impl;

import edu.just.bank.dao.CustomerDAO;
import edu.just.bank.domain.Customer;

public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {

	@Override
	public Customer getCustomer(int userId) {
		String sql = "SELECT customerid, name, age, identitynumber, telephone, address, "
				+ "accountid FROM customer WHERE userid = ?";
		
		return query(sql, userId);
	}

	@Override
	public Customer getCustomer1(int accountId) {
		String sql = "SELECT customerid, name, age, identitynumber, telephone, address, "
				+ "accountid FROM customer WHERE accountid = ?";
		
		return query(sql, accountId);
	}

}
