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
@Table(name="couleur_interieur")
public class CouleurInterieur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6759387934733172287L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_couleur_interieur")
	private int idCouleurI;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_marque")
	private Marque marque;
	public CouleurInterieur( String nomCouleurI) {
		super();
		this.nomCouleurI = nomCouleurI;
	}
	public int getIdCouleurI() {
		return idCouleurI;
	}
	public void setIdCouleurI(int idCouleurI) {
		this.idCouleurI = idCouleurI;
	}
	public String getNomCouleurI() {
		return nomCouleurI;
	}
	public void setNomCouleurI(String nomCouleurI) {
		this.nomCouleurI = nomCouleurI;
	}
	@Column(name="nom_couleur_interieur")
	private String  nomCouleurI;
	
	
}
