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


import com.spring.model.Vente;
import com.spring.repository.VenteRepository;
import com.spring.service.VenteService;


@RestController
@RequestMapping(path="/vente")
public class VenteController {
	@Autowired 
	VenteService venteService;
	@Autowired
	private VenteRepository cIRepository;
	@GetMapping(path="/getAllVentes")
	public List<Vente> getAllVentes(){
		List<Vente> venteList = new ArrayList<>();
		venteList.addAll(venteService.getAllVentes());
		return venteList;
	}
	@GetMapping("/getVenteById/{venteId}")	
	public List<Vente> getVenteByNom(@PathVariable(name="venteId")int idVente)	
	{	
	List<Vente> venteList = new ArrayList<>();
	venteList.addAll(venteService.getVenteById(idVente));
	return venteList;
	}
	@PostMapping("/saveVente")
	public String saveVente (@RequestBody Vente vente)
	{
		return venteService.saveVente(vente);
	}
	@DeleteMapping(path="/deleteVente")
	public String deleteVente(@RequestBody Vente vente ) {
		return venteService.deleteVente(vente);
	}
	
	@DeleteMapping(path="/deleteVenteId/{venteId}")
	public String deleteVenteById(@PathVariable(name="venteId")int venteId) {
		return venteService.deleteVenteById(venteId);
	}
	
	@GetMapping("/globalResultVente")
	public ResponseEntity<Integer> globalResultVente() {
		int resultat = this.venteService.globalResultVente();
		return ResponseEntity.ok(resultat);
	}
	@GetMapping("/resultVenteByColorE")
	public ResponseEntity<List<Object[]>> resultVenteByColort() {
		List<Object[]> resultat = this.venteService.resultVenteByColor();
		return ResponseEntity.ok(resultat);
	}
	@GetMapping("/resultVenteByColorI")
	public ResponseEntity<List<Object[]>> resultVenteByColorI() {
		List<Object[]> resultat = this.venteService.resultVenteByColorI();
		return ResponseEntity.ok(resultat);
	}
	@GetMapping("/resultVente")
	public ResponseEntity<List<Object[]>> resultVente() {
		List<Object[]> resultat = this.venteService.totalVente();
		return ResponseEntity.ok(resultat);
	}	
	@GetMapping("/resultVenteBySite")
	public ResponseEntity<List<Object[]>> resultVenteBySite() {
		List<Object[]> resultat = this.venteService.totalVenteBySite();
		return ResponseEntity.ok(resultat);
	}
	@GetMapping("/resultVenteByVille")
	public ResponseEntity<List<Object[]>> resultVenteByVille() {
		List<Object[]> resultat = this.venteService.totalVenteByVille();
		return ResponseEntity.ok(resultat);
	}
	@PutMapping("/updateVente/{id}")
	public ResponseEntity<Object> updateVente(@RequestBody Vente couleurE, @PathVariable int id) {

		java.util.Optional<Vente> cEOptional = cIRepository.findById(id);

		if (!cEOptional.isPresent())
			return ResponseEntity.notFound().build();

		couleurE.setIdVente(id);
		
		cIRepository.save(couleurE);

		return ResponseEntity.noContent().build();
	}

}
