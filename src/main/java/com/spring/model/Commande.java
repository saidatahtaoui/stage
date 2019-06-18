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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="commande")
public class Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5162838088831920057L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_commande")
	private int idCommande;
	@Column(name="quantite_commande")
	private int quantitecCmmande;
	@Column(name="date_commande")
	private String dateCommande;
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	@Column(name="delai_livraison")
	private int delaiLivraison;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_fournisseur")
	private Fournisseur fournisseur;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_societe")
	private Societe societe;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_version")
	private Version version;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_model")
	private Model model;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_couleur_interieur")
	private CouleurInterieur couleurI;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_couleur_exterieur")
	@JsonIgnore
	private CouleurExterieur couleurE;
	public Commande(int i, String string, int j, CouleurExterieur couleurExterieur, int k, Societe societe2, Version version2, CouleurInterieur couleurInterieur) {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(int quantitecCmmande, String dateCommande, int delaiLivraison, Fournisseur fournisseur,
			Societe societe, Version version, Model model, CouleurInterieur couleurI, CouleurExterieur couleurE) {
		super();
		this.quantitecCmmande = quantitecCmmande;
		this.dateCommande = dateCommande;
		this.delaiLivraison = delaiLivraison;
		this.fournisseur = fournisseur;
		this.societe = societe;
		this.version = version;
		this.model = model;
		this.couleurI = couleurI;
		this.couleurE = couleurE;
	}
	public Commande(int idCommande2, String dateCommande2, int delaiLivraison2, CouleurExterieur couleurE2,
			int quantitecCmmande2, Societe societe2, Version version2, CouleurInterieur couleurI2, Model model2) {
		// TODO Auto-generated constructor stub
	}
	public int getQuantitecCmmande() {
		return quantitecCmmande;
	}
	public void setQuantitecCmmande(int quantitecCmmande) {
		this.quantitecCmmande = quantitecCmmande;
	}
	public String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}
	public int getDelaiLivraison() {
		return delaiLivraison;
	}
	public void setDelaiLivraison(int delaiLivraison) {
		this.delaiLivraison = delaiLivraison;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public CouleurInterieur getCouleurI() {
		return couleurI;
	}
	public void setCouleurI(CouleurInterieur couleurI) {
		this.couleurI = couleurI;
	}
	public CouleurExterieur getCouleurE() {
		return couleurE;
	}
	public void setCouleurE(CouleurExterieur couleurE) {
		this.couleurE = couleurE;
	}
	public int getIdCommande() {
		// TODO Auto-generated method stub
		return idCommande;
	}
	
}
