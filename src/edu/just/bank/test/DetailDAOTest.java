package edu.just.bank.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.just.bank.dao.DetailDAO;
import edu.just.bank.dao.impl.DetailDAOImpl;
import edu.just.bank.domain.Detail;

class DetailDAOTest {
	
	DetailDAO detailDAO = new DetailDAOImpl();
	
	@Test
	void testInsertDetail() {
		List<Detail> details = detailDAO.listDetail(4);
		System.out.println(details);
	}

	@Test
	void testListDetail() {
	}

}
