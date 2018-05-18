package edu.just.bank.domain;

public class Account {

	private Integer accountId;
	private float minbalance;
	private float balance;
	private float rate;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public float getMinbalance() {
		return minbalance;
	}

	public void setMinbalance(float minbalance) {
		this.minbalance = minbalance;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", minbalance=" + minbalance + ", balance=" + balance + ", rate="
				+ rate + "]";
	}

}
