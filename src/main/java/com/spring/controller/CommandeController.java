package com.spring.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.ApiResponse;
import com.spring.model.Commande;
import com.spring.repository.CommandeRepository;
import com.spring.service.CommandeService;

@RestController
@RequestMapping(path="/commande")
public class CommandeController {

	@Autowired 
	CommandeService commandeService;
	@Autowired
	private CommandeRepository commandeRepository;
	@GetMapping(path="/getAllCommandes")
	public List<Commande> getAllClients(){
		List<Commande> commandeList = new ArrayList<>();
		commandeList.addAll(commandeService.getAllCommandes());
		return commandeList;
	}
	@GetMapping("/getCommandeById/{commandeId}")	
	public List<Commande> getCommandeByNom(@PathVariable(name="commandeId")int idCommande)	
	{	
	List<Commande> commandeList = new ArrayList<>();
	commandeList.addAll(commandeService.getCommandeById(idCommande));
	return commandeList;
	}
	@PostMapping("/saveCommande")
	public ResponseEntity<ApiResponse> saveCommande (@RequestBody Commande commande)
	{
		Commande result = this.commandeService.saveCommande(new Commande(commande.getIdCommande(), commande.getDateCommande(), commande.getDelaiLivraison(),
		commande.getCouleurE(),commande.getQuantitecCmmande(),commande.getSociete(),commande.getVersion(),commande.getCouleurI(),commande.getModel()));
		if (result!= null)
			return ResponseEntity.ok(new ApiResponse(true, "Commande registered successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Commande is not registered"));


	}
	@DeleteMapping(path="/deleteCommande")
	public String deleteCommande(@RequestBody Commande commande ) {
		return commandeService.deleteCommande(commande);
	}
	@DeleteMapping(path="/deleteCommandeId/{commandeId}")
	public String deleteCommandeById(@PathVariable(name="cpmmandeId")int commandeId) {
		return commandeService.deleteCommandeById(commandeId);
	}

	@GetMapping("/resultFournisseur")
	public ResponseEntity<List<Object[]>> resultFournisseur() {
		List<Object[]> resultat = this.commandeService.resultFournisseur();
		return ResponseEntity.ok(resultat);
	}
	@PutMapping("/updatecommande/{id}")
	public ResponseEntity<Object> updateCommande(@RequestBody Commande commande, @PathVariable int id) {

		java.util.Optional<Commande> commandeOptional = commandeRepository.findById(id);

		if (!commandeOptional.isPresent())
			return ResponseEntity.notFound().build();

		commande.setIdCommande(id);
		
		commandeRepository.save(commande);

		return ResponseEntity.noContent().build();
	}
	

}
