package edu.just.bank.dao.impl;

import edu.just.bank.dao.AccountDAO;
import edu.just.bank.domain.Account;

public class AccountDAOImpl extends BaseDAO<Account> implements AccountDAO {

	@Override
	public Account getAccount(String accountNumber) {
		String sql = "SELECT accountid, accountnumber, accountpassword, balance FROM account "
				+ "WHERE accountnumber = ?";
		return query(sql, accountNumber);
	}

	@Override
	public void depositBalance(String accountNumber, float amount) {
		String sql = "UPDATE account SET balance = balance + ? WHERE "
				+ "accountnumber = ?";
		
		update(sql, amount, accountNumber);
	}

	@Override
	public void withdrawBalance(String accountNumber, float amount) {
		String sql = "UPDATE account SET balance = balance - ? WHERE "
				+ "accountnumber = ?";
		
		update(sql, amount, accountNumber);
	}

	@Override
	public long countAcount(String accountNumber) {
		String sql = "SELECT count(*) FROM account WHERE accountNumber = ?";
		
		long count = getSingleVal(sql, accountNumber);
		return count;
	}

}
