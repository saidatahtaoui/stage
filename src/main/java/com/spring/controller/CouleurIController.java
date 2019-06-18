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
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.CouleurInterieur;
import com.spring.repository.CouleurIRepository;
import com.spring.service.CouleurIService;

public class CouleurIController {

	@Autowired
	CouleurIService couleurExtS;
	@Autowired
	CouleurIRepository cIRepo;
	@GetMapping(path="/getAllCouleurI")
	public List<CouleurInterieur> getCouleurI(){
		List<CouleurInterieur> couleurExts= new ArrayList<>();
		couleurExts.addAll(couleurExtS.getAllCouleurInt());
		return couleurExts;
		
	}
	@GetMapping(name="/getIById{couleurIId}")
	public List<CouleurInterieur> getExtById(@PathVariable (name="couleurExtId") int idExt){
		List<CouleurInterieur> listExt = new ArrayList<>();
		listExt.addAll(couleurExtS.getCouleurById(idExt));
		return listExt;
	}
	@PostMapping(path="/saveCouleurI")
	public CouleurInterieur saveCouleurExt (@RequestParam CouleurInterieur couleurExt)
	{
		return this.couleurExtS.saveCouleurInt(couleurExt);
	}
	@DeleteMapping(path="/deleteCouleurI")
	public String deleteCouleurI(@RequestBody CouleurInterieur couleurExt) {
		return couleurExtS.deleteCouleurInt(couleurExt);
	}
	@DeleteMapping(path="/deleteCouleurIId/{couleurIId}")
	public String deleteMarqueById(@PathVariable(name="couleurIId")int couleurExtId) {
		return couleurExtS.deleteCouleurIntById(couleurExtId);
	}
	@PutMapping("/updatecouleurE/{id}")
	public ResponseEntity<Object> updateCommande(@RequestBody CouleurInterieur commande, @PathVariable int id) {

		java.util.Optional<CouleurInterieur> commandeOptional = cIRepo.findById(id);

		if (!commandeOptional.isPresent())
			return ResponseEntity.notFound().build();

		commande.setIdCouleurI(id);
		
		cIRepo.save(commande);

		return ResponseEntity.noContent().build();
	

}
}
