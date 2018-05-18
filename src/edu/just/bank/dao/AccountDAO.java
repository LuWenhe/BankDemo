package edu.just.bank.dao;

import edu.just.bank.domain.Account;

public interface AccountDAO {

	/**
	 * 根据 accountId 获得 Account 对象
	 * @param accountId
	 * @return
	 */
	public abstract Account getAccount(Integer accountId);

	/**
	 * 根据 accountId, 存入相应的金额 amount
	 * @param accountId
	 * @param amount
	 */
	public abstract void depositBalance(Integer accountId, float amount);
	
	/**
	 * 根据 accountId, 取相应的金额 amount
	 * @param accountId
	 * @param amount
	 */
	public abstract void withdrawBalance(Integer accountId, float amount);

	/**
	 * 根据 accountId 获得账户用户的数目
	 * @param accountId
	 * @return
	 */
	public abstract long countAcount(int accountId);
	
}