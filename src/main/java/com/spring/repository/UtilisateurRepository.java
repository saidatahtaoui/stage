package com.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
