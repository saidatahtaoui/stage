package com.spring.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Model;
import com.spring.repository.ModelRepository;

@Service
public class ModelService {
	
	@Autowired
	ModelRepository modelRepo;

	public Optional<Model> findByNom(String nomModel) {
		return this.modelRepo.findByNomModel(nomModel);
	}

	public List<Model> getAllModels() {
		List<Model> modelList = new ArrayList<>();
		modelRepo.findAll().forEach(modelList::add);
		return modelList;
	}

	public Model saveModel(Model model) {
		return this.modelRepo.save(model);
	}

	public String deleteModel(Model model) {
				modelRepo.delete(model);
				return "deleted";
	}

	public String deleteModeltById(int modelId) {
		modelRepo.deleteById(modelId);
		return "deleted";
	}
	
	
}
