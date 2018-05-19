package edu.just.bank.dao.impl;

import java.util.List;

import edu.just.bank.dao.LoanDAO;
import edu.just.bank.domain.Loan;

public class LoanDAOImpl extends BaseDAO<Loan> implements LoanDAO {

	@Override
	public List<Loan> listLoan() {
		String sql = "SELECT loanid, loantype, minpayrate FROM loan";
		return queryForList(sql);
	}

	@Override
	public Loan getLoan(Integer loanId) {
		String sql = "SELECT loanid, loantype, minpayrate FROM loan WHERE "
				+ "loanId = ?";
		return query(sql, loanId);
	}

}
