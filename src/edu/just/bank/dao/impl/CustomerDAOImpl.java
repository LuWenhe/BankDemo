package edu.just.bank.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.just.bank.dao.CustomerDAO;
import edu.just.bank.domain.Customer;

public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {

	@Override
	public Customer getCustomer(int userId) {
		String sql = "SELECT customerid, name, age, identitynumber, telephone, address, "
				+ "userid FROM customer WHERE userid = ?";
		
		return query(sql, userId);
	}

	@Override
	public Set<Customer> getCustomersWithAccountId(Integer userId) {
		String sql = "SELECT customerid, name, age, identitynumber, telephone, address, "
				+ "userid FROM customer WHERE userid = ? ";
		
		List<Customer> list = queryForList(sql, userId);
		Set<Customer> set = new HashSet<>(list);
		return set;
	}

	@Override
	public void addCustomer(Customer customer, int userId) {
		String sql = "INSERT INTO customer(name, age, identitynumber, telephone, address, userid) "
				+ "VALUES(?,?,?,?,?,?)";
		
		insert(sql, customer.getName(), customer.getAge(), customer.getIdentityNumber(), customer.getTelephone(), 
				customer.getAddress(), customer.getuserId());
	}

}
