package edu.just.bank.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private int customerId;
	private String name;
	private int age;
	private String identityNumber;
	private String telephone;
	private String address;
	private int loanId;
	private int userId;

	public Customer() {}
	
	public Customer(String name, int age, String identityNumber, String telephone, String address, int userId) {
		this.name = name;
		this.age = age;
		this.identityNumber = identityNumber;
		this.telephone = telephone;
		this.address = address;
		this.userId = userId;
	}

	private Set<Detail> details = new HashSet<>();
	
	public void setDetails(Set<Detail> details) {
		this.details = details;
	}
	
	public Set<Detail> getDetails() {
		return details;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	
	public int getLoanId() {
		return loanId;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", age=" + age + ", identityNumber="
				+ identityNumber + ", telephone=" + telephone + ", address=" + address + ", userId=" + userId
				+ ", details=" + details + "]";
	}

}
