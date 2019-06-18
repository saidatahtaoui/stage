package com.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{
	
	Optional<Model> findByNomModel(String nomModel);
	

}
