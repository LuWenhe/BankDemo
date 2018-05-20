package edu.just.bank.service;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import edu.just.bank.dao.CustomerDAO;
import edu.just.bank.dao.DetailDAO;
import edu.just.bank.dao.impl.CustomerDAOImpl;
import edu.just.bank.dao.impl.DetailDAOImpl;
import edu.just.bank.domain.Customer;
import edu.just.bank.domain.Detail;

public class DetailService {

	DetailDAO detailDAO = new DetailDAOImpl();
	
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public List<Detail> getDetailList(Integer customerId) {
		return detailDAO.listDetail(customerId);
	}
	
	public void addDetails(Detail detail) {
		detailDAO.insert(detail);
	}
	
	public void addAccountDetails(Integer userId, float amount, String type) {
		String tradeNumber = getTradeNumber();
		
		Customer customer = customerDAO.getCustomer(userId);

		Detail detail = new Detail();
		
		detail.setDetailTime(new Date(new java.util.Date().getTime()));
		detail.setType(type);
		detail.setTradeNumber(tradeNumber);
		detail.setMoney(amount);
		detail.setcustomerId(customer.getCustomerId());
		
		detailDAO.insert(detail);
	}

	public String getTradeNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		
		String tradeNumber = System.currentTimeMillis() + randomNumber + "";
		
		return tradeNumber;
	}
}
