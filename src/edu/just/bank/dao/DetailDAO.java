package edu.just.bank.dao;

import java.util.List;

import edu.just.bank.domain.Detail;

public interface DetailDAO {

	public abstract void insert(Detail detail);
	
	public abstract List<Detail> listDetail(Integer customerId);
}
