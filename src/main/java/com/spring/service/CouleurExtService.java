package com.spring.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.CouleurExterieur;
import com.spring.repository.CouleurExtRepository;

@Service
public class CouleurExtService {
	@Autowired
	CouleurExtRepository extRepo;
	public List<CouleurExterieur> getAllCouleurExts() {
		// TODO Auto-generated method stub
		List<CouleurExterieur> extList = new ArrayList<>();
		extRepo.findAll().forEach(extList::add);
		return extList;
	}
	public List<CouleurExterieur> getCouleurById(int idExt) {
		// TODO Auto-generated method stub
		List<CouleurExterieur> extList = new ArrayList<>();
		extList.add(extRepo.findById(idExt).get());
		return extList;
	}
	public String saveCouleurExt(CouleurExterieur couleurExt) {
		// TODO Auto-generated method stub
		CouleurExterieur  savedExt = extRepo.save(couleurExt);
		if(savedExt!=null) {
			return "Saved : couleurExtrieur = "+ savedExt.getIdCouleurE();
		}
		else {
			return "Failed : couleurExterieur = "+ couleurExt.getIdCouleurE();

		}
		
	}
	public String deleteCouleurExt(CouleurExterieur couleurExt) {
		// TODO Auto-generated method stub
		extRepo.delete(couleurExt);
		return "Deleted";
	}
	public String deleteCouleurExtById(int couleurExtId) {
		// TODO Auto-generated method stub
		extRepo.deleteById(couleurExtId);
		return "Deleted";
	}

}
