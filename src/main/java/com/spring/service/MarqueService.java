package com.spring.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Marque;
import com.spring.repository.MarqueRepository;
@Service
public class MarqueService {

	@Autowired
	MarqueRepository marqueRepository;
	public List<Marque> getAllMarques() {
		// TODO Auto-generated method stub
		List<Marque> marqueList = new ArrayList<>();
		marqueRepository.findAll().forEach(marqueList::add);
		return marqueList;
	}
	public List<Marque> getMarqueById(int idMarque) {
		// TODO Auto-generated method stub
		List<Marque> marqueList= new ArrayList<>();
		marqueList.add(marqueRepository.findById(idMarque).get());
		return marqueList;
	}
	public Marque saveMarque(Marque marque) {
		// TODO Auto-generated method stub
		return this.marqueRepository.save(marque);

		
	}
	public String deleteMarque(Marque marque) {
		// TODO Auto-generated method stub
		marqueRepository.delete(marque);
		return "Deleted";
	}
	public String deleteMarqueById(int marqueId) {
		// TODO Auto-generated method stub
		marqueRepository.deleteById(marqueId);
		return "Deleted";
	}
	
	
}
