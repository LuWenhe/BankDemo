package edu.just.bank.dao;

import edu.just.bank.domain.User;

public interface UserDAO {

	public abstract User getUser(Integer userId);
	
	public abstract User getUser(String username);
	
	public abstract long addUser(User user, Integer accountId);
	
}
