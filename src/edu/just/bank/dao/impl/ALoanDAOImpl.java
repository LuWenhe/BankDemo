package edu.just.bank.dao.impl;

import edu.just.bank.dao.ALoanDAO;
import edu.just.bank.domain.ALoan;

public class ALoanDAOImpl extends BaseDAO<ALoan> implements ALoanDAO {

	@Override
	public void addALoan(ALoan aLoan) {
		String sql = "INSERT INTO aloan(loanamount, income, yearnum, loanid) "
				+ "VALUES(?,?,?,?)";
		
		long aLoanId = insert(sql, aLoan.getLoanAmount(), aLoan.getIncome(), aLoan.getYearNum(), aLoan.getLoanId());
		aLoan.setAloanId((int)aLoanId);
	}

	@Override
	public ALoan getALoan(Integer aLoanId) {
		String sql = "SELECT aloanid, loanamount, income, yearnum, loanid "
				+ "FROM aloan WHERE aloanid = ?";
		return query(sql, aLoanId);
	}

	
}
