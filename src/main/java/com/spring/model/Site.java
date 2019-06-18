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
@Table(name="site")
public class Site implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6831955916693509818L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_site")
	private int idSite;
	@Column(name="nom_site")
	private String nomSite;
	@ManyToOne(optional=true)
	@JoinColumn(name="id_societe")
	private Societe societe;
	@OneToMany(mappedBy="site", cascade=CascadeType.ALL)
	private List<Vente> ventes;
	@Column(name="ville_site")
	private String villeSite;
	public String getVilleSite() {
		return villeSite;
	}
	public void setVilleSite(String villeSite) {
		this.villeSite = villeSite;
	}
	public int getIdSite() {
		return idSite;
	}
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}
	public String getNomSite() {
		return nomSite;
	}
	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}
	public Site(String nomSite) {
		super();
		this.nomSite = nomSite;
	}
	

}
