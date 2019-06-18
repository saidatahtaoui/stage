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

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="version")
public class Version implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7025606863103429674L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_version")
	private int idVersion;
	@NaturalId
	@Column(name="v_version")
	private String vVersion;
	@Column(name="nom_version")
	private String nomVersion;
	@OneToMany(mappedBy="version", cascade=CascadeType.ALL)
	private List<Model> models;
	public Version() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Version(String vVersion, String nomVersion) {
		super();
		this.vVersion = vVersion;
		this.nomVersion = nomVersion;
	}
	public Version(int idVersion2, String nomVersion2, List<Model> models2) {
		// TODO Auto-generated constructor stub
	}
	public Version(int idVersion2, String nomVersion2, List<Model> models2, String getvVersion) {
		// TODO Auto-generated constructor stub
	}
	public String getvVersion() {
		return vVersion;
	}
	public void setvVersion(String vVersion) {
		this.vVersion = vVersion;
	}

	public int getIdVersion() {
		return idVersion;
	}
	public void setIdVersion(int idVersion) {
		this.idVersion = idVersion;
	}
	public String getNomVersion() {
		return nomVersion;
	}
	public void setNomVersion(String nomVersion) {
		this.nomVersion = nomVersion;
	}
	public List<Model> getModels() {
		return models;
	}
	public void setModels(List<Model> models) {
		this.models = models;
	}


}
