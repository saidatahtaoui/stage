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


import com.spring.model.Gamme;
import com.spring.repository.GammeRepository;
import com.spring.service.GammeService;


@RestController
@RequestMapping(path="/gamme")

public class GammeController {
	@Autowired
	GammeService gammeService;
	@Autowired
	private GammeRepository gammeRepository;
	@GetMapping(path="/getAllGammes")
	public List<Gamme> getAllGammes(){
		List<Gamme> gammeList = new ArrayList<>();
		gammeList.addAll(gammeService.getAllGammes());
		return gammeList;

	}
	@GetMapping(path="/getGammeById/{gammeId}")	
	public List<Gamme> getGammeById(@PathVariable(name="gammeId")int idGamme)	
	{	
	List<Gamme> gammeList = new ArrayList<>();
	gammeList.addAll(gammeService.getGammeById(idGamme));
	return gammeList;
	}
	@PostMapping(path="/saveGamme")
	public ResponseEntity<ApiResponse>  saveGamme (@RequestBody Gamme gamme)
	{
		
		
				Gamme result = this.gammeService.saveGamme(new Gamme(gamme.getIdGamme(), gamme.getNomGamme(),gamme.getvGamme(),gamme.getFamille()));
				int result1 = result.getIdGamme();
				String result3=result.getNomGamme();
				String vGamme=result1+result3;
				gamme.setvGamme(vGamme);
				Gamme result4 = this.gammeService.saveGamme(new Gamme(result1, gamme.getNomGamme(),gamme.getvGamme(),gamme.getFamille()));


				if (result4 != null)
					return ResponseEntity.ok(new ApiResponse(true, "Client registered successfully"));
				else
					return ResponseEntity.ok(new ApiResponse(false, "Error Client is not registered"));
			
	}
	@DeleteMapping(path="/deleteGamme")
	public String deleteGamme(@RequestBody Gamme gamme) {
		return gammeService.deleteGamme(gamme);
	}
	@DeleteMapping(path="/deleteGammeId/{gammeId}")
	public String deleteGammeById(@PathVariable(name="gammeId")int gammeId) {
		return gammeService.deleteGammeById(gammeId);
	}

	@PutMapping("/updategamme/{id}")
	public ResponseEntity<Object> updateGamme(@RequestBody Gamme gamme, @PathVariable int id) {
		java.util.Optional<Gamme> gammeOptional = gammeRepository.findById(id);

		if (!gammeOptional.isPresent())
			return ResponseEntity.notFound().build();

		gamme.setIdGamme(id);
		
		gammeRepository.save(gamme);
		int result1 = gamme.getIdGamme();
		String result3=gamme.getNomGamme();
		String vGamme=result1+result3;
		gamme.setvGamme(vGamme);
		Gamme result4 = this.gammeService.saveGamme(new Gamme(result1, gamme.getNomGamme(),gamme.getvGamme(),gamme.getFamille()));
		if (result4 != null)
			return ResponseEntity.ok(new ApiResponse(true, "Gamme registered successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Gamme is not registered"));
	
	
	}
	

}
