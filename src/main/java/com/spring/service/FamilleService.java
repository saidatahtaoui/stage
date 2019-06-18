package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Famille;
import com.spring.repository.FamilleRepository;


@Service
public class FamilleService {
	@Autowired
	FamilleRepository familleRepository;
	public List<Famille> getAllFamilles() {
		// TODO Auto-generated method stub
		List<Famille> familleList = new ArrayList<>();
		familleRepository.findAll().forEach(familleList::add);
		return familleList;
	}
	public List<Famille> getFamilleById(int idFamille) {
		// TODO Auto-generated method stub
		List<Famille> familleList= new ArrayList<>();
		familleList.add(familleRepository.findById(idFamille).get());
		return familleList;
	}
	public Famille saveFamille(Famille famille) {
		return this.familleRepository.save(famille);

	
	}
	public String deleteFamille(Famille famille) {
		// TODO Auto-generated method stub
		familleRepository.delete(famille);
		return "Deleted";
	}
	public String deleteFamilleById(int familleId) {
		// TODO Auto-generated method stub
		familleRepository.deleteById(familleId);
		return "Deleted";
	}
	
	

}
