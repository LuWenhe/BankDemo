package edu.just.bank.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Account {

	private Integer accountid;
	private String accountNumber;
	private String accountPassword;
	private int balance;
	
	private Set<Customer> customers = new LinkedHashSet<>();
	
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	public Set<Customer> getCustomers() {
		return customers;
	}
	
	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	
	public String getAccountPassword() {
		return accountPassword;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountNumber=" + accountNumber + ", accountPassword="
				+ accountPassword + ", balance=" + balance + "]";
	}

}
