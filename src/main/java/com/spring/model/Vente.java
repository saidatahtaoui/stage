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
@Table(name="vente")
public class Vente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -533237696814170235L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_vente")
	private int idVente;
	@Column(name="date_vente")
	private String dateVente;
	@Column(name="quantite_vente")
	private int quantiteVente;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_client")
	private Client client;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_site")
	private Site site;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_couleur_exterieur")
	private CouleurExterieur couleurE;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_couleur_interieur")
	private CouleurInterieur couleurI;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_version")
	private Version version;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_marque")
	private Marque marque;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_model")
	private Model model;

	public Vente(String dateVente, int quantiteVente, Client client, Site site, CouleurExterieur couleurE,
		CouleurInterieur couleurI, Version version, Marque marque, Model model) {
	super();
	this.dateVente = dateVente;
	this.quantiteVente = quantiteVente;
	this.client = client;
	this.site = site;
	this.couleurE = couleurE;
	this.couleurI = couleurI;
	this.version = version;
	this.marque = marque;
	this.model = model;
}
	public Vente(String dateVente, int quantiteVente) {
		super();
		this.dateVente = dateVente;
		this.quantiteVente = quantiteVente;
	}
	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdVente() {
		return idVente;
	}
	public void setIdVente(int idVente) {
		this.idVente = idVente;
	}
	public String getDateVente() {
		return dateVente;
	}
	public void setDateVente(String dateVente) {
		this.dateVente = dateVente;
	}
	public int getQuantiteVente() {
		return quantiteVente;
	}
	public void setQuantiteVente(int quantiteVente) {
		this.quantiteVente = quantiteVente;
	}

}
