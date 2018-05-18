package edu.just.bank.service;

import edu.just.bank.dao.UserDAO;
import edu.just.bank.dao.impl.UserDAOImpl;
import edu.just.bank.domain.User;

public class UserService {

	UserDAO userDAO = new UserDAOImpl();
	
	public User getUserWithUserId(Integer userId) {
		User user = userDAO.getUser(userId);
		return user;
	}
	
	public User getUserWithUsername(String username) {
		User user = userDAO.getUser(username);
		return user;
	}
	
	public long addUser(User user, Integer accountId) {
		return userDAO.addUser(user, accountId);
	}
	
}
