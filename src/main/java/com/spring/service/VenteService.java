package com.spring.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.model.Vente;
import com.spring.repository.VenteRepository;

@Service
public class VenteService {
	@Autowired
	VenteRepository venteRepository;
	
	public List<Vente> getAllVentes(){
		List<Vente> venteList = new ArrayList<>();
		venteRepository.findAll().forEach(venteList::add);
		return venteList;
	}
	
	public List<Vente> getVenteById(int idVente){
		
		List<Vente> venteList = new ArrayList<>();
		venteList.add(venteRepository.findById(idVente).get());
		return venteList;
	}

	public String saveVente(Vente vente) {
		
		Vente savedVente= venteRepository.save(vente);
		if(savedVente!=null) {
			return "Saved : vente = "+ savedVente.getIdVente();
		}
		else {
			return "Failed : vente = "+ vente.getIdVente();

		}
		
	}

	public String deleteVente(Vente vente) {
		// TODO Auto-generated method stub
		venteRepository.delete(vente);
		return "Deleted";
	}
	
	public int globalResultVente() {
		return this.venteRepository.globalVenteVersion();
	}

	public String deleteVenteById(int venteId) {
		// TODO Auto-generated method stub
		venteRepository.deleteById(venteId);
		return "Deleted";
	}
	
	public List<Object[]> resultVenteByColor() {
		return this.venteRepository.resultVenteByColorE();
	}
	public List<Object[]> resultVenteByColorI() {
		return this.venteRepository.resultVenteByColorI();
	}
	
	public List<Object[]> totalVente(){
		return this.venteRepository.resultVente();
	}
	public List<Object[]> totalVenteBySite(){
		return this.venteRepository.resultVenteBySite();
	}
	public List<Object[]> totalVenteByVille(){
		return this.venteRepository.resultVenteByVille();
	}

}
