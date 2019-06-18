package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.LigneReservation;
import com.spring.repository.LigneReservationRepository;

@Service
public class LigneReservationService {
	@Autowired
	LigneReservationRepository ligneRRepository;
	
	public List<LigneReservation> getAllLReservations(){
		List<LigneReservation> ligneRList = new ArrayList<>();
		ligneRRepository.findAll().forEach(ligneRList::add);
		return ligneRList;
	}
	
	public List<LigneReservation> getLigneById(int idLigneR){
		
		List<LigneReservation> ligneRList = new ArrayList<>();
		ligneRList.add(ligneRRepository.findById(idLigneR).get());
		return ligneRList;
	}

	public LigneReservation saveLigne(LigneReservation ligneR) {
		
		
		return this.ligneRRepository.save(ligneR);

	}

	public String deleteLigne(LigneReservation res) {
		// TODO Auto-generated method stub
		ligneRRepository.delete(res);
		return "Deleted";
	}

	public String deleteLigneById(int resId) {
		// TODO Auto-generated method stub
		ligneRRepository.deleteById(resId);
		return "Deleted";
	}

}
