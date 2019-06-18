package com.spring.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8253611743595077671L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_stock")
	private int idStock;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_marque")
	private Marque marque;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_model")
	private Model model;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_version")
	private Version version;
	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}
	@Column(name="date_entree")
	private Date dateEntree;
	@Column(name="date_sortie")
	private Date dateSortie;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_couleur_interieur")
	private CouleurInterieur couleurI;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_couleur_exterieur")
	private CouleurExterieur couleurE;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_gamme")
	private Gamme gamme;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(Marque marque, Model model, Version version, CouleurInterieur couleurI, CouleurExterieur couleurE,
			Gamme gamme) {
		super();
		this.marque = marque;
		this.model = model;
		this.version = version;
		this.couleurI = couleurI;
		this.couleurE = couleurE;
		this.gamme = gamme;
	}
	public Stock(String date_entree, String date_sortie,CouleurExterieur id_couleur_exterieur, Gamme v_gamme, Marque v_marque, Model v_model,
			Version v_version) {
		this.dateEntree = Date.from(Instant.parse(date_entree)); //parse(date_entree);
		this.dateSortie=Date.from(Instant.parse(date_sortie));
		this.gamme = v_gamme;
		this.version = v_version;
		this.model = v_model;
		this.couleurE = id_couleur_exterieur;
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
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
	public Gamme getGamme() {
		return gamme;
	}
	public void setGamme(Gamme gamme) {
		this.gamme = gamme;
	}
	public Date getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public int getIdStock() {
		// TODO Auto-generated method stub
		return idStock;
	}
	

}
