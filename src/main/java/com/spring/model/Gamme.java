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

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="gamme")
public class Gamme implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5286027259777267199L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_gamme")
	private int idGamme;
	@NaturalId
	@Column(name="v_gamme")
	private String vGamme;
	@Column(name="nom_gamme")
	private String nomGamme;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_famille")
	private Famille famille;
	public Gamme(String nomGamme) {
		super();
		this.nomGamme = nomGamme;
	}
	public int getIdGamme() {
		return idGamme;
	}
	public void setIdGamme(int idGamme) {
		this.idGamme = idGamme;
	}
	public String getNomGamme() {
		return nomGamme;
	}
	public void setNomGamme(String nomGamme) {
		this.nomGamme = nomGamme;
	}
	public Gamme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gamme(int idGamme, String vGamme, String nomGamme) {
		super();
		this.idGamme = idGamme;
		this.vGamme = vGamme;
		this.nomGamme = nomGamme;
	}
	public Gamme(int idGamme, String vGamme, String nomGamme, Famille famille) {
		super();
		this.idGamme = idGamme;
		this.vGamme = vGamme;
		this.nomGamme = nomGamme;
		this.famille = famille;
	}
	public Gamme(int idGamme, String nomGamme, Famille famille) {
		super();
		this.idGamme = idGamme;
		this.nomGamme = nomGamme;
		this.famille=famille; 
	}
	public String getvGamme() {
		return vGamme;
	}
	public void setvGamme(String vGamme) {
		this.vGamme = vGamme;
	}
	public Famille getFamille() {
		return famille;
	}
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
}
