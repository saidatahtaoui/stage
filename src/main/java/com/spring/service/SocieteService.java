package com.spring.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.model.Societe;
import com.spring.repository.SocieteRepository;

@Service
public class SocieteService {
	@Autowired
	SocieteRepository societeRepo;
	@GetMapping(name="/getAllSocietes")
	public List<Societe> getAllSocietes() {
		// TODO Auto-generated method stub
		List<Societe> societeList =new ArrayList<>();
		societeRepo.findAll().forEach(societeList::add);
		return societeList;
	}
	public List<Societe> getSocieteById(int idSociete) {
		// TODO Auto-generated method stub
		List<Societe> societeList= new ArrayList<>();
		societeList.add(societeRepo.findById(idSociete).get());
		return societeList;
	}
	public Societe saveSociete(Societe societe) {
		// TODO Auto-generated method stub
		return this.societeRepo.save(societe);

	}
	public String deleteSociete(Societe societe) {
		// TODO Auto-generated method stub
		societeRepo.delete(societe);
		return "Deleted";
	}
	public String deleteSocieteById(int societeId) {
		// TODO Auto-generated method stub
		societeRepo.deleteById(societeId);
		return "Deleted";
	}
	

}
