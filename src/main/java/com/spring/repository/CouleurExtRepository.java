package com.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.model.CouleurExterieur;

public interface CouleurExtRepository extends CrudRepository<CouleurExterieur, Integer>{

	public CouleurExterieur findByNomCouleurE(String nom);

}
