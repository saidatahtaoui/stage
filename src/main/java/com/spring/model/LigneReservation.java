package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ligne_resrvation")
public class LigneReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ligne_reservation")
	private int idLReservation;
	public void setIdLReservation(int idLReservation) {
		this.idLReservation = idLReservation;
	}
	@Column(name="etat_reservation")
	private String etatResrvation;
	@Column(name="quantite_reservation")
	private int qunatiteResrvation;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_version")
	private Version version;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_model")
	private Model model;
	@ManyToOne(optional=false)
	@JoinColumn(name="v_gamme")
	private Gamme gamme;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_couleur_interieur")
	private CouleurInterieur couleurI;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_couleur_exterieur")
	private CouleurExterieur couleurE;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_resrvation")
	private Reservation resrvation;
	public String getEtatResrvation() {
		return etatResrvation;
	}
	public void setEtatResrvation(String etatResrvation) {
		this.etatResrvation = etatResrvation;
	}
	public int getQunatiteResrvation() {
		return qunatiteResrvation;
	}
	public void setQunatiteResrvation(int qunatiteResrvation) {
		this.qunatiteResrvation = qunatiteResrvation;
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
	public Gamme getGamme() {
		return gamme;
	}
	public void setGamme(Gamme gamme) {
		this.gamme = gamme;
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
	public Reservation getResrvation() {
		return resrvation;
	}
	public void setResrvation(Reservation resrvation) {
		this.resrvation = resrvation;
	}
	public LigneReservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneReservation(String etatResrvation, int qunatiteResrvation, Version version, Model model, Gamme gamme,
			CouleurInterieur couleurI, CouleurExterieur couleurE, Reservation resrvation) {
		super();
		this.etatResrvation = etatResrvation;
		this.qunatiteResrvation = qunatiteResrvation;
		this.version = version;
		this.model = model;
		this.gamme = gamme;
		this.couleurI = couleurI;
		this.couleurE = couleurE;
		this.resrvation = resrvation;
	}
	public LigneReservation(CouleurExterieur couleurE2, CouleurInterieur couleurI2, String etatResrvation2,
			String idLReservation2, Model model2, Version version2, int qunatiteResrvation2, Reservation resrvation2) {
		// TODO Auto-generated constructor stub
	}
	public String getIdLReservation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
