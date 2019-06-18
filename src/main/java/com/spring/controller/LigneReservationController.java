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

import com.spring.dto.ApiResponse;

import com.spring.model.LigneReservation;
import com.spring.repository.LigneReservationRepository;
import com.spring.service.LigneReservationService;

@RequestMapping(path="/LReservation")
public class LigneReservationController {
	@Autowired 
	LigneReservationService ligneService;
	@Autowired
	private LigneReservationRepository lRRepository;
	@GetMapping(path="/getAllLignes")
	public List<LigneReservation> getAllLignes(){
		List<LigneReservation> ligneList = new ArrayList<>();
		ligneList.addAll(ligneService.getAllLReservations());
		return ligneList;
	}
	@GetMapping("/getVenteById/{venteId}")	
	public List<LigneReservation> getLigneByNom(@PathVariable(name="ligneId")int idLigne)	
	{	
	List<LigneReservation> ligneList = new ArrayList<>();
	ligneList.addAll(ligneService.getLigneById(idLigne));
	return ligneList;
	}
	@PostMapping("/saveVente")
	public ResponseEntity<ApiResponse> saveLigne (@RequestBody LigneReservation ligne)
	{
			LigneReservation result = this.ligneService.saveLigne(new LigneReservation(ligne.getCouleurE(),ligne.getCouleurI(),ligne.getEtatResrvation(),ligne.getIdLReservation(),ligne.getModel(),ligne.getVersion(),ligne.getQunatiteResrvation(),ligne.getResrvation()));

				if (result != null)
					return ResponseEntity.ok(new ApiResponse(true, "Ligne registered successfully"));
				else
					return ResponseEntity.ok(new ApiResponse(false, "Error Ligneis not registered"));
			
	}
	@DeleteMapping(path="/deleteVente")
	public String deleteLigne(@RequestBody LigneReservation ligne ) {
		return ligneService.deleteLigne(ligne);
	}
	@DeleteMapping(path="/deleteLigneId/{ligneId}")
	public String deleteLigneById(@PathVariable(name="ligneId")int ligneId) {
		return ligneService.deleteLigneById(ligneId);
	}
	@PutMapping("/updateligneReservation/{id}")
	public ResponseEntity<Object> updateExt(@RequestBody  LigneReservation ligne, @PathVariable int id) {

		java.util.Optional<LigneReservation> cEOptional = lRRepository.findById(id);

		if (!cEOptional.isPresent())
			return ResponseEntity.notFound().build();

		ligne.setIdLReservation(id);
		
		lRRepository.save(ligne);

		return ResponseEntity.noContent().build();
	}

}
