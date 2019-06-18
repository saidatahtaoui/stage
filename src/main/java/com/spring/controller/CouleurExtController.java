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

import com.spring.model.CouleurExterieur;
import com.spring.repository.CouleurExtRepository;
import com.spring.service.CouleurExtService;

@RestController
@RequestMapping(path="/couleurE")

public class CouleurExtController {
	@Autowired
	CouleurExtService couleurExtS;
	@Autowired
	CouleurExtRepository cERepo;
	@GetMapping(path="/getAllCouleurEx")
	public List<CouleurExterieur> getCouleurExt(){
		List<CouleurExterieur> couleurExts= new ArrayList<>();
		couleurExts.addAll(couleurExtS.getAllCouleurExts());
		return couleurExts;
		
	}
	@GetMapping(name="/getExtById{couleurExtId}")
	public List<CouleurExterieur> getExtById(@PathVariable (name="couleurExtId") int idExt){
		List<CouleurExterieur> listExt = new ArrayList<>();
		listExt.addAll(couleurExtS.getCouleurById(idExt));
		return listExt;
	}
	@PostMapping(path="/saveCouleurExt")
	public String saveCouleurExt (CouleurExterieur couleurExt)
	{
		return couleurExtS.saveCouleurExt(couleurExt);
	}
	@DeleteMapping(path="/deleteCouleurExt")
	public String deleteCouleurExt(@RequestBody CouleurExterieur couleurExt) {
		return couleurExtS.deleteCouleurExt(couleurExt);
	}
	@DeleteMapping(path="/deleteCouleurExtId/{couleurExtId}")
	public String deleteMarqueById(@PathVariable(name="couleurExtId")int couleurExtId) {
		return couleurExtS.deleteCouleurExtById(couleurExtId);
	}
	@PutMapping("/updatecouleurE/{id}")
	public ResponseEntity<Object> updateCommande(@RequestBody CouleurExterieur commande, @PathVariable int id) {

		java.util.Optional<CouleurExterieur> commandeOptional = cERepo.findById(id);

		if (!commandeOptional.isPresent())
			return ResponseEntity.notFound().build();

		commande.setIdCouleurE(id);
		
		cERepo.save(commande);

		return ResponseEntity.noContent().build();
	}
	

}
