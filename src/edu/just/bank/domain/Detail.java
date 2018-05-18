package edu.just.bank.domain;

import java.sql.Date;

public class Detail {

	private Integer detailId;
	private String type;
	private Date detailTime;
	private float money;
	private String tradeNumber;
	private Integer customerId;

	public Integer getcustomerId() {
		return customerId;
	}

	public void setcustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDetailTime() {
		return detailTime;
	}

	public void setDetailTime(Date detailTime) {
		this.detailTime = detailTime;
	}
	
	public void setMoney(float money) {
		this.money = money;
	}
	
	public float getMoney() {
		return money;
	}

	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	
	public String getTradeNumber() {
		return tradeNumber;
	}

	@Override
	public String toString() {
		return "Detail [detailId=" + detailId + ", type=" + type + ", detailTime=" + detailTime + ", money=" + money
				+ ", tradeNumber=" + tradeNumber + ", customerId=" + customerId + "]";
	}
	
}
