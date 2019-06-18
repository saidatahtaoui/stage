package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Fournisseur;
import com.spring.repository.FournisseurRepository;

@Service
public class FournisseurService {
	@Autowired
	FournisseurRepository fournisseurRepository;
	public List<Fournisseur> getAllFournisseurs() {
		// TODO Auto-generated method stub
		List<Fournisseur> fournisseurList = new ArrayList<>();
		fournisseurRepository.findAll().forEach(fournisseurList::add);
		return fournisseurList;
	}
	public List<Fournisseur> getFournisseurById(int idFournisseur) {
		// TODO Auto-generated method stub
		List<Fournisseur> fournisseurList= new ArrayList<>();
		fournisseurList.add(fournisseurRepository.findById(idFournisseur).get());
		return fournisseurList;
	}
	public String saveFournisseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		Fournisseur savedFournisseur=fournisseurRepository.save(fournisseur);
		if(savedFournisseur!=null) {
			return "Saved : famille = "+ savedFournisseur.getIdFournisseur();
		}
		else {
			return "Failed : famille = "+fournisseur.getIdFournisseur();

		}
	}
	public String deleteFournisseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		fournisseurRepository.delete(fournisseur);
		return "Deleted";
	}
	public String deleteFournisseurById(int fournisseurId) {
		// TODO Auto-generated method stub
		fournisseurRepository.deleteById(fournisseurId);
		return "Deleted";
	}
	

}
