package com.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.spring.model.Fournisseur;
@CrossOrigin(origins = "http://localhost:4200")
public interface FournisseurRepository extends CrudRepository<Fournisseur , Integer>{

}
