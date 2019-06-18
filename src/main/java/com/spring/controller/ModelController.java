package com.spring.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

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
import com.spring.model.Model;
import com.spring.service.ModelService;

@RestController
@RequestMapping("/model")
public class ModelController {
	@Autowired
	ModelService modelService;
	@GetMapping("/get/{nomModel}")
	public ResponseEntity<Model> findByNom(@PathVariable(value="nomModel")  String nomModel){
		Optional<Model> value = this.modelService.findByNom(nomModel);
		if (value.isPresent())
			return ResponseEntity.ok(value.get());
		else
			return null;
	}
	@GetMapping("/get")
	public List<Model> getAllModels(){
		List<Model> modelList = new ArrayList<>();
		modelList.addAll(modelService.getAllModels());
		return modelList;
	}
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> saveModel(@RequestBody Model model){
		Model result = this.modelService.saveModel(new Model(model.getNomModel(), model.getvModel(), model.getMarque(),model.getVersion()));
		if (result != null)
			return ResponseEntity.ok(new ApiResponse(true, "Model registered successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Model is not registered"));
	}
	@DeleteMapping(path="/deleteModel")
	public String deleteModel(@RequestBody Model model ) {
		return modelService.deleteModel(model);
	}
	@DeleteMapping(path="/deleteModelId/{modelId}")
	public String deleteModelById(@PathVariable(name="modelId")int modelId) {
		return modelService.deleteModeltById(modelId);
	}
	@PutMapping("/update")
	public ResponseEntity<ApiResponse> updateModel(@RequestBody Model model){
		
		Model result = this.modelService.saveModel(new Model(model.getNomModel(), model.getvModel(), model.getMarque(),model.getVersion()));
		int result1 = result.getIdModel();
		String result3=result.getNomModel();
		String vModel=result1+result3;
		model.setvModel(vModel);			
			//clientService.deleteClientById(result1);
		Model result4 = this.modelService.saveModel(new Model(result1, model.getNomModel(), model.getvModel()));
		if (result4 != null)
			return ResponseEntity.ok(new ApiResponse(true, "Model updated successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Model is not updated"));
	}
}