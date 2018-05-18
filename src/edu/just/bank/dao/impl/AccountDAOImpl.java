package edu.just.bank.dao.impl;

import edu.just.bank.dao.AccountDAO;
import edu.just.bank.domain.Account;

public class AccountDAOImpl extends BaseDAO<Account> implements AccountDAO {

	@Override
	public Account getAccount(Integer accountId) {
		String sql = "SELECT accountId accountid, minbalance, balance, rate FROM account WHERE accountid = ?";
		return query(sql, accountId);
	}

	@Override
	public void depositBalance(Integer accountId, float amount) {
		String sql = "UPDATE account SET balance = balance + ? WHERE "
				+ "accountid = ?";
		update(sql, amount, accountId);
	}

	@Override
	public void withdrawBalance(Integer accountId, float amount) {
		String sql = "UPDATE account SET balance = balance - ? WHERE "
				+ "accountid = ?";
		update(sql, amount, accountId);
	}

	@Override
	public long countAcount(int accountId) {
		return 0;
	}

}
