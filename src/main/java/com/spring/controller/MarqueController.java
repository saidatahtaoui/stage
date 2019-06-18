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
import com.spring.model.Marque;
import com.spring.repository.MarqueRepository;
import com.spring.service.MarqueService;

@RestController
@RequestMapping(path="/marque")
public class MarqueController {
	
	@Autowired
	MarqueService marqueService;
	@Autowired
	private MarqueRepository marqueRepository;
	@GetMapping(path="/getAllMarques")
	public List<Marque> getAllClients(){
		List<Marque> marqueList = new ArrayList<>();
		marqueList.addAll(marqueService.getAllMarques());
		return marqueList;

	}
	@GetMapping(path="/getMarqueById/{marqueId}")	
	public List<Marque> getMarqueById(@PathVariable(name="marqueId")int idMarque)	
	{	
	List<Marque> marqueList = new ArrayList<>();
	marqueList.addAll(marqueService.getMarqueById(idMarque));
	return marqueList;
	}
	@PostMapping(path="/saveMarque")
	public ResponseEntity<ApiResponse> saveMarque (@RequestBody Marque marque)
	{
		Marque result = this.marqueService.saveMarque(new Marque(marque.getIdMarque(), marque.getNomMarque()));
		int result1 = result.getIdMarque();
		String result3=result.getNomMarque();
		String vMarque=result1+result3;
		marque.setVMarque(vMarque);			
			//clientService.deleteClientById(result1);
		Marque result4 = this.marqueService.saveMarque(new Marque(result1, marque.getNomMarque(), marque.getVMarque()));
		if (result4 != null)
			return ResponseEntity.ok(new ApiResponse(true, "Marque registered successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Marque is not registered"));
	}
	@DeleteMapping(path="/deleteMarque")
	public String deleteMarque(@RequestBody Marque marque ) {
		return marqueService.deleteMarque(marque);
	}
	@DeleteMapping(path="/deleteMarqueId/{marqueId}")
	public String deleteMarqueById(@PathVariable(name="marqueId")int marqueId) {
		return marqueService.deleteMarqueById(marqueId);
	}
	@PutMapping("/updateclient/{id}")
	public ResponseEntity<Object> updateMarque(@RequestBody Marque marque, @PathVariable int id) {

		java.util.Optional<Marque> clientOptional =marqueRepository.findById(id);

		if (!clientOptional.isPresent())
			return ResponseEntity.notFound().build();

		marque.setIdMaque(id);
		
		marqueRepository.save(marque);
		int result1 = marque.getIdMarque();
		String result3=marque.getNomMarque();
		String vMarque=result1+result3;
		marque.setVMarque(vMarque);
		Marque result4 = this.marqueService.saveMarque(new Marque(result1, marque.getNomMarque(), marque.getVMarque()));
		if (result4 != null)
			return ResponseEntity.ok(new ApiResponse(true, "Marque registered successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Marque is not registered"));
	}
}
