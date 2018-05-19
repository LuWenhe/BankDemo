package edu.just.bank.service;

import java.util.List;

import edu.just.bank.dao.LoanDAO;
import edu.just.bank.dao.impl.LoanDAOImpl;
import edu.just.bank.domain.Loan;

public class LoanService {

	LoanDAO loanDAO = new LoanDAOImpl();
	
	public List<Loan> getListLoan() {
		return loanDAO.listLoan();
	}
	
	public Loan getLoanWithLoanId(Integer loanId) {
		return loanDAO.getLoan(loanId);
	}
	
}
