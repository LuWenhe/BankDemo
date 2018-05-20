package edu.just.bank.service;

import java.util.Random;

import edu.just.bank.dao.AccountDAO;
import edu.just.bank.dao.impl.AccountDAOImpl;
import edu.just.bank.domain.Account;

public class AccountService {
	
	private AccountDAO accountDAO = new AccountDAOImpl();
	
	public Account getAccountWithAccountId(int accountId) {
		return accountDAO.getAccount(accountId);
	}
	
	public void depositAmount(int accountId, float amount) {
		accountDAO.depositBalance(accountId, amount);
	}
	
	public void withAmount(int accountId, float amount) {
		accountDAO.withdrawBalance(accountId, amount);
	}

	public String getTradeNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		
		String tradeNumber = System.currentTimeMillis() + randomNumber + "";
		
		return tradeNumber;
	}

}
