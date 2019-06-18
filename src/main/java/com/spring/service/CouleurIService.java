package com.spring.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.CouleurInterieur;
import com.spring.repository.CouleurIRepository;


@Service
public class CouleurIService {
	@Autowired
	CouleurIRepository iRepo;
	public List<CouleurInterieur> getAllCouleurInt() {
		// TODO Auto-generated method stub
		List<CouleurInterieur> intList = new ArrayList<>();
		iRepo.findAll().forEach(intList::add);
		return intList;
	}
	public List<CouleurInterieur> getCouleurById(int idInt) {
		// TODO Auto-generated method stub
		List<CouleurInterieur> intList = new ArrayList<>();
		intList.add(iRepo.findById(idInt).get());
		return intList;
	}
	public CouleurInterieur saveCouleurInt(CouleurInterieur couleurInt) {
		// TODO Auto-generated method stub
		return this.iRepo.save(couleurInt);

		
	}
	public String deleteCouleurInt(CouleurInterieur couleurI) {
		// TODO Auto-generated method stub
		iRepo.delete(couleurI);;
		return "Deleted";
	}
	public String deleteCouleurIntById(int couleurIntId) {
		// TODO Auto-generated method stub
		iRepo.deleteById(couleurIntId);
		return "Deleted";
	}

}
