package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Commande;
import com.spring.repository.CommandeRepository;

@Service
public class CommandeService {
	@Autowired
	CommandeRepository commandeRepository;
	
	public List<Commande> getAllCommandes(){
		List<Commande> commandeList = new ArrayList<>();
		commandeRepository.findAll().forEach(commandeList::add);
		return commandeList;
	}
	
	public List<Commande> getCommandeById(int idCommande){
		
		List<Commande> commandeList = new ArrayList<>();
		commandeList.add(commandeRepository.findById(idCommande).get());
		return commandeList;
	}

	public Commande saveCommande(Commande commande) {
		
		return this.commandeRepository.save(commande);
		
	}

	public String deleteCommande(Commande commande) {
		// TODO Auto-generated method stub
		commandeRepository.delete(commande);
		return "Deleted";
	}

	public String deleteCommandeById(int commandeId) {
		// TODO Auto-generated method stub
		commandeRepository.deleteById(commandeId);
		return "Deleted";
	}
	public List<Object[]>resultFournisseur(){
		return this.commandeRepository.resultFournisseur();

	}

}
