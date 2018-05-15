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
	private int accountId;

	public Customer() {}
	
	public Customer(int customerId, String name, int age, String identityNumber, String telephone, String address,
			int accountId) {
		this.customerId = customerId;
		this.name = name;
		this.age = age;
		this.identityNumber = identityNumber;
		this.telephone = telephone;
		this.address = address;
		this.accountId = accountId;
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

	public int getAccountId() {
		return accountId;
	}

	public void setaccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", age=" + age + ", identityNumber="
				+ identityNumber + ", telephone=" + telephone + ", address=" + address + ", accountId=" + accountId
				+ ", details=" + details + "]";
	}

}
