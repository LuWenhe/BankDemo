package edu.just.bank.dao.impl;

import edu.just.bank.dao.DetailDAO;
import edu.just.bank.domain.Detail;

public class DetailDAOImpl extends BaseDAO<Detail> implements DetailDAO {

	@Override
	public void insert(Detail detail) {
		String sql = "INSERT INTO detail(detailid, detailtime, type, money, customerid) "
				+ "VALUES(?,?,?,?,?)";
		insert(sql, null, detail.getDetailTime(), detail.getType(), 
				detail.getMoney(), detail.getcustomerId());
	}

}
