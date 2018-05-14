package edu.just.bank.dao.utils;

public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBException() {
	}
	
	public DBException(String msg) {
		super(msg);
	}
	
	public DBException(String msg, Exception ex) {
		super(msg, ex);
	}
}
