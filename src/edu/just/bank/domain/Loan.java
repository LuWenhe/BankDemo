package edu.just.bank.domain;

public class Loan {

	private int loanId;
	private String loanType;
	private float minPayRate;
	private float rate;
	
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

	public void setRate(float rate) {
		this.rate = rate;
	}
	
	public float getRate() {
		return rate;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", minPayRate=" + minPayRate + ", rate=" + rate
				+ "]";
	}
	
}
