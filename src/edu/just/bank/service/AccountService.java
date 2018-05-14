package edu.just.bank.service;

import java.sql.Date;
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
	
	AccountDAO accountDAO = new AccountDAOImpl();
	
	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	DetailDAO detailDAO = new DetailDAOImpl();
	
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
	
	public void addDepositDetails(String accountNumber, float amount, String type) {
		accountDAO.depositBalance(accountNumber, amount);
		Account account = accountDAO.getAccount(accountNumber);
		Detail detail = new Detail();
		
		Set<Customer> customers = customerDAO.getCustomersWithAccountId(account.getAccountid());

		for(Customer customer: customers) {
			detail.setcustomerId(customer.getCustomerId());
			detail.setMoney(amount);
			detail.setDetailTime(new Date(new java.util.Date().getTime()));
			detail.setType(type);
			
			detailDAO.insert(detail);
		}
	}

}
