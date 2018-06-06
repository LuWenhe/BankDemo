package edu.just.bank.test;

import org.junit.jupiter.api.Test;

import edu.just.bank.dao.UserDAO;
import edu.just.bank.dao.impl.UserDAOImpl;
import edu.just.bank.domain.User;

class UserDAOTest {

	UserDAO userDAO = new UserDAOImpl();
	
	@Test
	void testGetUser() {
		System.out.println(userDAO.getUser("aaaaa"));
	}

	@Test
	void testAddUser() {
		User user = new User();
		user.setUsername("luwenhe");
		user.setPassword("123");
		
		userDAO.addUser(user, 1);
	}

}
