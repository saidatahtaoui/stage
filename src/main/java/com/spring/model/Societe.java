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
@Table(name="societe")
public class Societe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1079508385911515887L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_societe")
	private int idSociete;
	@Column(name="nom_societe")
	private String nomSociete;
	@OneToMany(mappedBy="societe", cascade=CascadeType.ALL)
	private List<Site> sites;
	@OneToMany(mappedBy="societe", cascade=CascadeType.ALL)
	private List<Fournisseur> fournisseurs;
	@OneToMany(mappedBy="societe", cascade=CascadeType.ALL)
	private List<Commande> commandes;
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Societe(String nomSociete) {
		super();
		this.nomSociete = nomSociete;
	}
	public int getIdSociete() {
		return idSociete;
	}
	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public Societe(int idSociete, String nomSociete) {
		super();
		this.idSociete = idSociete;
		this.nomSociete = nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

}
