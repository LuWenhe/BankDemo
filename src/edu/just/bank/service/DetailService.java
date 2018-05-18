package edu.just.bank.service;

import java.util.List;

import edu.just.bank.dao.DetailDAO;
import edu.just.bank.dao.impl.DetailDAOImpl;
import edu.just.bank.domain.Detail;

public class DetailService {

	DetailDAO detailDAO = new DetailDAOImpl();
	
	public List<Detail> getDetailList(Integer customerId) {
		return detailDAO.listDetail(customerId);
	}
	
	public void addDetails(Detail detail) {
		detailDAO.insert(detail);
	}
}
