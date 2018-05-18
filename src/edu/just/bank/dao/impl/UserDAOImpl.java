package edu.just.bank.dao.impl;

import edu.just.bank.dao.UserDAO;
import edu.just.bank.domain.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

	@Override
	public User getUser(Integer userId) {
		String sql = "SELECT userid, username, password, accountid FROM user "
				+ "WHERE userid = ?";
		return query(sql, userId);
	}

	@Override
	public User getUser(String username) {
		String sql = "SELECT userid, username, password, accountid FROM user "
				+ "WHERE username = ?";
		return query(sql, username);
	}

	@Override
	public long addUser(User user, Integer accountId) {
		String sql = "INSERT INTO user(username, password, accountid) "
				+ "VALUES(?,?,?)";
		return insert(sql, user.getUsername(), user.getPassword(), accountId);
	}

}
