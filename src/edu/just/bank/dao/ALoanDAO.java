package edu.just.bank.dao;

import edu.just.bank.domain.ALoan;

public interface ALoanDAO {

	public abstract ALoan getALoan(ALoan aLoan);
	
	public abstract void addALoan(ALoan aLoan);
}
