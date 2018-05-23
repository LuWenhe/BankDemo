package edu.just.bank.dao.impl;

import java.util.List;

import edu.just.bank.dao.DetailDAO;
import edu.just.bank.domain.Detail;

public class DetailDAOImpl extends BaseDAO<Detail> implements DetailDAO {

	@Override
	public void insert(Detail detail) {
		String sql = "INSERT INTO detail(detailid, detailtime, type, money, tradenumber, customerid) "
				+ "VALUES(?,?,?,?,?,?)";
		insert(sql, null, detail.getDetailTime(), detail.getType(), 
				detail.getMoney(), detail.getTradeNumber(), detail.getcustomerId());
	}

	@Override
	public List<Detail> listDetail(Integer customerId) {
		String sql = "SELECT detailid, detailtime, type, money, tradenumber, customerid FROM detail "
				+ "WHERE customerid = ?";
		return queryForList(sql, customerId);
	}

}
