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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="model")
public class Model implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5039315008671227120L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_model")
	private int idModel;
	@Column(name="v_model")
	@NaturalId
	private String vModel;
	public int getIdModel() {
		return idModel;
	}
	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}
	@Column(name="nom_model")
	private String nomModel;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_marque")
	@JsonIgnore
	private Marque marque;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_version")
	@JsonIgnore
	private Version version;
	
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getvModel() {
		return vModel;
	}
	public void setvModel(String vModel) {
		this.vModel = vModel;
	}
	public String getNomModel() {
		return nomModel;
	}
	public void setNomModel(String nomModel) {
		this.nomModel = nomModel;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Version getVersion() {
		return version;
	}

	public Model(int idModel, String nomModel) {
		super();
		this.idModel = idModel;
		this.nomModel = nomModel;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	public Model(int idModel, String vModel, String nomModel) {
		super();
		this.idModel = idModel;
		this.vModel = vModel;
		this.nomModel = nomModel;
	}
	public Model(String vModel, String nomModel, Marque marque, Version version) {
		super();
		this.vModel = vModel;
		this.nomModel = nomModel;
		this.marque = marque;
		this.version = version;
	}
}
