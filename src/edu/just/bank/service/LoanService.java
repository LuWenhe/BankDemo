package edu.just.bank.service;

import java.util.List;

import edu.just.bank.dao.ALoanDAO;
import edu.just.bank.dao.LoanDAO;
import edu.just.bank.dao.impl.ALoanDAOImpl;
import edu.just.bank.dao.impl.LoanDAOImpl;
import edu.just.bank.domain.ALoan;
import edu.just.bank.domain.Loan;

public class LoanService {

	LoanDAO loanDAO = new LoanDAOImpl();
	
	ALoanDAO aLoanDAO = new ALoanDAOImpl();
	
	public List<Loan> getListLoan() {
		return loanDAO.listLoan();
	}
	
	public Loan getLoanWithLoanId(Integer loanId) {
		return loanDAO.getLoan(loanId);
	}
	
	public void addALoanWithALoanId(ALoan aLoan) {
		aLoanDAO.addALoan(aLoan);
	}
	
	public void addLoanDetail(Loan loan, ALoan aLoan) {
		aLoanDAO.addALoan(aLoan);
	}
	
	public ALoan getALoanWithALoanId(Integer aLoanId) {
		return aLoanDAO.getALoan(aLoanId);
	}
}
