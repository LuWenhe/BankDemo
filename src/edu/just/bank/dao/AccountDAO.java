package edu.just.bank.dao;

import edu.just.bank.domain.Account;

public interface AccountDAO {

	/**
	 * ���� accountId ��� Account ����
	 * @param accountId
	 * @return
	 */
	public abstract Account getAccount(Integer accountId);

	/**
	 * ���� accountId, ������Ӧ�Ľ�� amount
	 * @param accountId
	 * @param amount
	 */
	public abstract void depositBalance(Integer accountId, float amount);
	
	/**
	 * ���� accountId, ȡ��Ӧ�Ľ�� amount
	 * @param accountId
	 * @param amount
	 */
	public abstract void withdrawBalance(Integer accountId, float amount);

	/**
	 * ���� accountId ����˻��û�����Ŀ
	 * @param accountId
	 * @return
	 */
	public abstract long countAcount(int accountId);
	
}