package edu.just.bank.dao;

import edu.just.bank.domain.Account;

public interface AccountDAO {

	/**
	 * 根据 accountNumber 获得 Account 对象
	 * @param accountNumber
	 * @return
	 */
	public abstract Account getAccount(String accountNumber);

	/**
	 * 根据 accountNumber, 存入相应的金额 amount
	 * @param accountNumber
	 * @param amount
	 */
	public abstract void depositBalance(String accountNumber, float amount);
	
	/**
	 * 根据 accountNumber, 取相应的金额 amount
	 * @param accountNumber
	 * @param amount
	 */
	public abstract void withdrawBalance(String accountNumber, float amount);

	/**
	 * 根据 accountNumber 获得账户用户的数目
	 * @param accountNumber
	 * @return
	 */
	public abstract long countAcount(String accountNumber);
}