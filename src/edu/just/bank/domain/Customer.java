package edu.just.bank.domain;

public class Customer {

	private int customerId;
	private String name;
	private int age;
	private String identityNumber;
	private String telephone;
	private String address;
	private int balance;
	private int userId;

	public Customer() {}
	
	public Customer(int customerId, String name, int age, String identityNumber, String telephone, String address,
			int userId) {
		this.customerId = customerId;
		this.name = name;
		this.age = age;
		this.identityNumber = identityNumber;
		this.telephone = telephone;
		this.address = address;
		this.userId = userId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", age=" + age + ", identityNumber="
				+ identityNumber + ", telephone=" + telephone + ", address=" + address + ", balance=" + balance
				+ ", userId=" + userId + "]";
	}

}
