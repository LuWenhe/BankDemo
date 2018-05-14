package edu.just.bank.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.just.bank.dao.CustomerDAO;
import edu.just.bank.domain.Customer;

public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {

	@Override
	public Customer getCustomer(int accountId) {
		String sql = "SELECT customerid, name, age, identitynumber, telephone, address, "
				+ "accountid FROM customer WHERE accountid = ?";
		
		return query(sql, accountId);
	}

	@Override
	public Set<Customer> getCustomersWithAccountId(Integer accountId) {
		String sql = "SELECT customerid, name, age, identitynumber, telephone, "
				+ "address, accountid FROM customer WHERE accountid = ? ";
		
		List<Customer> list = queryForList(sql, accountId);
		Set<Customer> set = new HashSet<>(list);
		return set;
	}

}
