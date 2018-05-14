package edu.just.bank.test;

import org.junit.jupiter.api.Test;

import edu.just.bank.dao.AccountDAO;
import edu.just.bank.dao.impl.AccountDAOImpl;
import edu.just.bank.domain.Account;

class AccountDAOTest {

	private AccountDAO accountDAO = new AccountDAOImpl();
	
	@Test
	void testGetAccount() {
		Account account = accountDAO.getAccount("2222333344440000");
		System.out.println(account);
	}

	@Test
	void testDepositBalance() {
		accountDAO.depositBalance("2222333344440000", 1000);
	}

	@Test
	void testWithdrawBalance() {
		accountDAO.withdrawBalance("2222333344440000", 100);
	}

	@Test
	void testCountAcount() {
		long count = accountDAO.countAcount("2222333344440001");
		System.out.println(count);
	}
}
