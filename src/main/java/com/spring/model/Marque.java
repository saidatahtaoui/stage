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
@Table(name="marque")
public class Marque implements Serializable {
	public Marque() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -2900891596887099870L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_marque")
	private int idMarque;
	@Column(name="nom_marque")
	private String nomMarque;
	//@NaturalId
	@Column(name="v_marque")
	private String VMarque;
	@OneToMany(mappedBy="marque", cascade=CascadeType.ALL)
	private List<CouleurExterieur> couleurE;
	@OneToMany(mappedBy="marque" , cascade=CascadeType.ALL)
	private List<CouleurInterieur> couleurI;
	@OneToMany(mappedBy="marque", cascade=CascadeType.ALL)
	private List<Model> models;
	public Marque(String nomMarque, String vMarque) {
		super();
		this.nomMarque = nomMarque;
		VMarque = vMarque;
	}
	public int getIdMarque() {
		return idMarque;
	}
	public void setIdMaque(int idMarque) {
		this.idMarque = idMarque;
	}
	public String getNomMarque() {
		return nomMarque;
	}
	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}
	public String getVMarque() {
		return VMarque;
	}
	public Marque(int idMarque, String nomMarque, String vMarque) {
		super();
		this.idMarque = idMarque;
		this.nomMarque = nomMarque;
		VMarque = vMarque;
	}
	public Marque(int idMarque, String nomMarque) {
		super();
		this.idMarque = idMarque;
		this.nomMarque = nomMarque;
	}
	public void setVMarque(String vMarque) {
		VMarque = vMarque;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
