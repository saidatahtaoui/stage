package com.spring.dao;

import java.util.List;


import com.spring.model.Utilisateur;



public interface CustomerDao {
	public void insert(List<? extends Utilisateur> customers);
	List<Utilisateur> loadAllCustomers();
}
