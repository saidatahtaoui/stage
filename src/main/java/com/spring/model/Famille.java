package com.spring.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="famille")
public class Famille implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2037825410096861509L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_famille")
	private int idFamille;
	@Column(name="nom_famille")
	private String nomFamille;
	@Column(name="v_famille")
	private String vFamille;
	@OneToMany(mappedBy="famille", cascade=CascadeType.ALL)
	private List<Gamme> gammes;
	public Famille(String nomFamille) {
		super();
		this.nomFamille = nomFamille;
	}
	public int getIdFamille() {
		return idFamille;
	}
	public String getvFamille() {
		return vFamille;
	}
	public void setvFamille(String vFamille) {
		this.vFamille = vFamille;
	}
	public List<Gamme> getGammes() {
		return gammes;
	}
	public void setGammes(List<Gamme> gammes) {
		this.gammes = gammes;
	}
	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}
	public String getNomFamille() {
		return nomFamille;
	}
	public Famille() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Famille(int idFamille, String nomFamille, List<Gamme> gammes) {
		super();
		this.idFamille = idFamille;
		this.nomFamille = nomFamille;
		this.gammes = gammes;
	}
	public Famille(int idFamille2, String nomFamille2) {
		// TODO Auto-generated constructor stub
	}
	public Famille(int result1, String nomFamille2, String getvFamille) {
		// TODO Auto-generated constructor stub
	}
	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}
}
