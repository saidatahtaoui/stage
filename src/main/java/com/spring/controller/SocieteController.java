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
import com.spring.model.Societe;
import com.spring.repository.SocieteRepository;
import com.spring.service.SocieteService;

@RestController
@RequestMapping(path="/societe")
public class SocieteController {
	
	@Autowired
	SocieteService societeService;
	@Autowired
	private SocieteRepository cIRepository;
	@GetMapping(path="/getAllSocietes")
	public List<Societe> getAllSocietes(){
		List<Societe> societeList = new ArrayList<>();
		societeList.addAll(societeService.getAllSocietes());
		return societeList;

    }
	@GetMapping(path="/getSocieteById/{societeId}")	
	public List<Societe> getSocieteById(@PathVariable(name="societeId")int idSociete)	
	{	
	List<Societe> societeList = new ArrayList<>();
	societeList.addAll(societeService.getSocieteById(idSociete));
	return societeList;
	}
	@PostMapping(path="/saveSociete")
	public ResponseEntity<ApiResponse>  saveSociete (@RequestBody Societe societe)
	{
		Societe result = this.societeService.saveSociete(new Societe(societe.getIdSociete(), societe.getNomSociete()));
		if (result != null)
			return ResponseEntity.ok(new ApiResponse(true, "Societe registered successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Societe is not registered"));

	}
	@DeleteMapping(path="/deleteSociete")
	public String deleteMSociete(@RequestBody Societe societe ) {
		return societeService.deleteSociete(societe);
	}
	@DeleteMapping(path="/deleteSocieteId/{societeId}")
	public String deleteSocieteById(@PathVariable(name="societeId")int societeId) {
		return societeService.deleteSocieteById(societeId);
	}
	@PutMapping("/updatesociete/{id}")
	public ResponseEntity<Object> updateSite(@RequestBody Societe couleurE, @PathVariable int id) {

		java.util.Optional<Societe> cEOptional = cIRepository.findById(id);

		if (!cEOptional.isPresent())
			return ResponseEntity.notFound().build();

		couleurE.setIdSociete(id);
		
		cIRepository.save(couleurE);

		return ResponseEntity.noContent().build();
	}
}


