package edu.just.bank.service;

import java.sql.Date;
import java.util.Random;
import java.util.Set;

import edu.just.bank.dao.AccountDAO;
import edu.just.bank.dao.CustomerDAO;
import edu.just.bank.dao.DetailDAO;
import edu.just.bank.dao.impl.AccountDAOImpl;
import edu.just.bank.dao.impl.CustomerDAOImpl;
import edu.just.bank.dao.impl.DetailDAOImpl;
import edu.just.bank.domain.Account;
import edu.just.bank.domain.Customer;
import edu.just.bank.domain.Detail;

public class AccountService {
	
	private AccountDAO accountDAO = new AccountDAOImpl();
	
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	private DetailDAO detailDAO = new DetailDAOImpl();
	
	public Account getAccountWithAccountId(int accountId) {
		return accountDAO.getAccount(accountId);
	}
	
	public void depositAmount(int accountId, float amount) {
		accountDAO.depositBalance(accountId, amount);
	}
	
	public void withAmount(int accountId, float amount) {
		accountDAO.withdrawBalance(accountId, amount);
	}
	
	public void addAccountDetails(Integer accountId, float amount, String type) {
//		Detail detail = new Detail();
//		
//		String tradeNumber = getTradeNumber();
//		
//		Account account = accountDAO.getAccount(accountId);
//
//		Set<Customer> customers = customerDAO.getCustomersWithUserId(account.getAccountId());
//
//		for(Customer customer: customers) {
//			detail.setcustomerId(customer.getCustomerId());
//			detail.setMoney(amount);
//			detail.setDetailTime(new Date(new java.util.Date().getTime()));
//			detail.setType(type);
//			detail.setTradeNumber(tradeNumber);
//			
//			detailDAO.insert(detail);
//		}
	}

	public String getTradeNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		
		String tradeNumber = System.currentTimeMillis() + randomNumber + "";
		
		return tradeNumber;
	}

}
