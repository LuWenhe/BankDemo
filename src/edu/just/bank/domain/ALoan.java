package edu.just.bank.domain;

public class ALoan {

	private Integer aloanId;
	private float loanAmount;
	private float income;
	private Integer yearNum;

	public ALoan(float loanAmount, float income, Integer yearNum) {
		this.loanAmount = loanAmount;
		this.income = income;
		this.yearNum = yearNum;
	}

	public Integer getAloanId() {
		return aloanId;
	}

	public void setAloanId(Integer aloanId) {
		this.aloanId = aloanId;
	}

	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	public Integer getYearNum() {
		return yearNum;
	}

	public void setYearNum(Integer yearNum) {
		this.yearNum = yearNum;
	}

}
