package edu.just.bank.dao;

import java.util.List;

import edu.just.bank.domain.Loan;

public interface LoanDAO {

	public abstract List<Loan> listLoan();
	
	public abstract Loan getLoan(Integer loanId);
	
}
