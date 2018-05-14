package edu.just.bank.service;

import edu.just.bank.dao.AccountDAO;
import edu.just.bank.dao.impl.AccountDAOImpl;
import edu.just.bank.domain.Account;

public class AccountService {
	
	AccountDAO accountDAO = new AccountDAOImpl();
	
	public Account getAccountWithAccountNumber(String accountNumber) {
		return accountDAO.getAccount(accountNumber);
	}
	
	public void depositBalance(String accountNumber, float amount) {
		accountDAO.depositBalance(accountNumber, amount);
	}
	
	public void withdrawBalance(String accountNumber, float amount) {
		accountDAO.withdrawBalance(accountNumber, amount);
	}
	
	public void transferBalance(String fromAccountNumber,
			String toAccountNumber, float amount) {
		accountDAO.withdrawBalance(fromAccountNumber, amount);
		accountDAO.depositBalance(toAccountNumber, amount);
	}
	
	public long getCountWithAccountNumber(String accountNumber) {
		return accountDAO.countAcount(accountNumber);
	}

}
