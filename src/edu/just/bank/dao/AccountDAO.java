package edu.just.bank.dao;

import edu.just.bank.domain.Account;

public interface AccountDAO {

	/**
	 * ���� accountNumber ��� Account ����
	 * @param accountNumber
	 * @return
	 */
	public abstract Account getAccount(String accountNumber);

	/**
	 * ���� accountNumber, ������Ӧ�Ľ�� amount
	 * @param accountNumber
	 * @param amount
	 */
	public abstract void depositBalance(String accountNumber, float amount);
	
	/**
	 * ���� accountNumber, ȡ��Ӧ�Ľ�� amount
	 * @param accountNumber
	 * @param amount
	 */
	public abstract void withdrawBalance(String accountNumber, float amount);

	/**
	 * ���� accountNumber ����˻��û�����Ŀ
	 * @param accountNumber
	 * @return
	 */
	public abstract long countAcount(String accountNumber);
}