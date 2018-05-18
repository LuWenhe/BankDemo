package edu.just.bank.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.just.bank.dao.AccountDAO;
import edu.just.bank.dao.impl.AccountDAOImpl;

class AccountDAOTest {

	private AccountDAO accountDAO = new AccountDAOImpl();
	
	@Test
	void testGetAccount() {
		System.out.println(accountDAO.getAccount(9));
	}

	@Test
	void testDepositBalance() {
		fail("Not yet implemented");
	}

	@Test
	void testWithdrawBalance() {
		fail("Not yet implemented");
	}

	@Test
	void testCountAcount() {
		fail("Not yet implemented");
	}

}
