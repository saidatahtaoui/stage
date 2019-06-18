package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="couleur_exterieur")
public class CouleurExterieur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -694126315486262374L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_couleur_exterieur")
	private int idCouleurE;
	@Column(name="nom_couleur_exterieur")
	private String nomCouleurE;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_marque")
	private Marque marque;
	public int getIdCouleurE() {
		return idCouleurE;
	}
	public void setIdCouleurE(int idCouleurE) {
		this.idCouleurE = idCouleurE;
	}
	public String getNomCouleurE() {
		return nomCouleurE;
	}
	public void setNomCouleurE(String nomCouleurE) {
		this.nomCouleurE = nomCouleurE;
	}
	public CouleurExterieur(String nomCouleurE) {
		super();
		this.nomCouleurE = nomCouleurE;
	}
	

}
