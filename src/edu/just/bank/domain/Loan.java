package edu.just.bank.domain;

public class Loan {

	private int loanId;
	private String loanType;
	private float minPayRate;
	private int accountId;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public float getMinPayRate() {
		return minPayRate;
	}

	public void setMinPayRate(float minPayRate) {
		this.minPayRate = minPayRate;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", minPayRate=" + minPayRate + ", accountId="
				+ accountId + "]";
	}

}
