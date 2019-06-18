package com.spring.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Fournisseur;

import com.spring.repository.FournisseurRepository;
import com.spring.service.FournisseurService;

@RestController
@RequestMapping(path="/Fournisseur")
@CrossOrigin(origins = "http://localhost:4200")

public class FournisseurController {

	@Autowired
	FournisseurService fournisseurService;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@GetMapping(path="/getAllFournisseurs")
	public List<Fournisseur> getAllFournisseurs(){
		List<Fournisseur> fournisseurList = new ArrayList<>();
		fournisseurList.addAll(fournisseurService.getAllFournisseurs());
		return fournisseurList;

	}
	@GetMapping(path="/getFournisseurById/{fournisseurId}")	
	public List<Fournisseur> getFournisseurById(@PathVariable(name="founisseurId")int idFournisseur)	
	{	
	List<Fournisseur> fournisseurList = new ArrayList<>();
	fournisseurList.addAll(fournisseurService.getFournisseurById(idFournisseur));
	return fournisseurList;
	}
	@PostMapping(path="/saveFounisseur")
	public String saveFamille ( @RequestBody Fournisseur fournisseur)
	{
		return fournisseurService.saveFournisseur(fournisseur);
	}
	@DeleteMapping(path="/deleteFournisseur")
	public String deleteFournisseur(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.deleteFournisseur(fournisseur);
	}
	@DeleteMapping(path="/deleteFournisseurId/{fournisseurId}")
	public String deleteFournisseurById(@PathVariable(name="fournisseurId")int fournisseurId) {
		return fournisseurService.deleteFournisseurById(fournisseurId);
	}@PutMapping("/updatefournisseur/{id}")
	public ResponseEntity<Object> updateFournisseur(@RequestBody Fournisseur fournisseur, @PathVariable int id) {

		java.util.Optional<Fournisseur> fOptional = fournisseurRepository.findById(id);

		if (!fOptional.isPresent())
			return ResponseEntity.notFound().build();

		fournisseur.setIdFournisseur(id);
		
		fournisseurRepository.save(fournisseur);

		return ResponseEntity.noContent().build();
	}
	

}
