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
import com.spring.model.Famille;
import com.spring.repository.FamilleRepository;
import com.spring.service.FamilleService;



@RestController
@RequestMapping(path="/famille")
public class FamilleController {
	@Autowired
	FamilleService familleService;
	@Autowired
	private FamilleRepository familleRepository;
	@GetMapping(path="/getAllFamilles")
	public List<Famille> getAllFamilles(){
		List<Famille> familleList = new ArrayList<>();
		familleList.addAll(familleService.getAllFamilles());
		return familleList;

	}
	@GetMapping(path="/getFamilleById/{familleId}")	
	public List<Famille> getMarqueById(@PathVariable(name="familleId")int idFamille)	
	{	
	List<Famille> familleList = new ArrayList<>();
	familleList.addAll(familleService.getFamilleById(idFamille));
	return familleList;
	}
	@PostMapping(path="/saveFamille")
	public ResponseEntity<ApiResponse> saveFamille (@RequestBody Famille famille)
	{
		Famille result = this.familleService.saveFamille(new Famille(famille.getIdFamille(), famille.getNomFamille()));
		int result1 = result.getIdFamille();
		String result3=result.getNomFamille();
		String vFamille=result1+result3;
		famille.setvFamille(vFamille);		
			//clientService.deleteClientById(result1);
		Famille result4 = this.familleService.saveFamille(new Famille(result1, famille.getNomFamille(), famille.getvFamille()));


		if (result4 != null)
			return ResponseEntity.ok(new ApiResponse(true, "Client registered successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Client is not registered"));
	}
	
	@DeleteMapping(path="/deleteFamille")
	public String deleteFamille(@RequestBody Famille famille) {
		return familleService.deleteFamille(famille);
	}
	@DeleteMapping(path="/deleteFamilleId/{familleId}")
	public String deleteFamilleById(@PathVariable(name="familleId")int familleId) {
		return familleService.deleteFamilleById(familleId);
	}
	@PutMapping("/updatefamille/{id}")
	public ResponseEntity<Object> updateFamille(@RequestBody Famille famille, @PathVariable int id) {
		java.util.Optional<Famille> clientOptional = familleRepository.findById(id);

		if (!clientOptional.isPresent())
			return ResponseEntity.notFound().build();

		famille.setIdFamille(id);
		
		familleRepository.save(famille);
		int result1 = famille.getIdFamille();
		String result3=famille.getNomFamille();
		String vFamille=result1+result3;
		famille.setvFamille(vFamille);
		Famille result4 = this.familleService.saveFamille(new Famille(result1, famille.getNomFamille(), famille.getvFamille()));
		if (result4 != null)
			return ResponseEntity.ok(new ApiResponse(true, "Client registered successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Client is not registered"));
	}
}
