package com.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fournisseur")
public class Fournisseur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6912444119099432462L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_fournisseur")
	private int idFournisseur;
	@Column(name="nom_fournisseur")
	private String nomFournisseur;
	@Column(name="pays_fournisseur")
	private String paysFournisseur;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_societe")
	private Societe societe;
	@OneToMany(mappedBy="fournisseur", cascade=CascadeType.ALL)
	private List<Commande> commandes;
	public Fournisseur(String nomFournisseur, String paysFournisseur) {
		super();
		this.nomFournisseur = nomFournisseur;
		this.paysFournisseur = paysFournisseur;
	}
	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}
	public String getPaysFournisseur() {
		return paysFournisseur;
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setPaysFournisseur(String paysFournisseur) {
		this.paysFournisseur = paysFournisseur;
	}
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur=idFournisseur;
	}

}
