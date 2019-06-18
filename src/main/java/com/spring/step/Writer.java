package com.spring.step;

import java.util.List;



import org.springframework.batch.item.ItemWriter;

import com.spring.dao.CustomerDao;
import com.spring.model.Utilisateur;


public class Writer implements ItemWriter<Utilisateur> {

	private final CustomerDao customerDao;

	public Writer(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void write(List<? extends Utilisateur> customers) throws Exception {
		customerDao.insert(customers);
	}

	
		
	
}
