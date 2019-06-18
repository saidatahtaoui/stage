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
@Table(name="client")
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7545760163730483156L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_client")
	private int idClient;
	@Column(name="nom_client")
	private  String nomClient;
	@Column(name="numero_telephone")
	private String numeroTelephone;
	@Column(name="mail_client")
	private String mailClient;
	@Column(name="genre")
	private String genre;
	@Column(name="v_client")
	private String vClient;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Vente> ventes;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Reservation> reservations;

	public String getGenre() {
		return genre;
	}

	public Client(int idClient, String nomClient, String numeroTelephone, String mailClient, String genre,
			Object object) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.numeroTelephone = numeroTelephone;
		this.mailClient = mailClient;
		this.genre = genre;
		this.vClient = (String) object;
	}
	public String getvClient() {
		return vClient;
	}
	public void setvClient(String vClient) {
		this.vClient = vClient;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}



	public Client(String nomClient, String numeroTelephone, String mailClient, String genre, List<Vente> ventes,
			List<Reservation> reservations) {
		super();
		this.nomClient = nomClient;
		this.numeroTelephone = numeroTelephone;
		this.mailClient = mailClient;
		this.genre = genre;
		this.ventes = ventes;
		this.reservations = reservations;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int idClient, String nomClient, String numeroTelephone, String mailClient, String genre) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.numeroTelephone = numeroTelephone;
		this.mailClient = mailClient;
		this.genre = genre;
	}

	public Client(int idClient, String nomClient, String numeroTelephone, String mailClient, String genre,
			String vClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.numeroTelephone = numeroTelephone;
		this.mailClient = mailClient;
		this.genre = genre;
		this.vClient = vClient;
	}

	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return this.nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getNumeroTelephone() {
		return this.numeroTelephone;
	}
	public void setNumeroTelephone(String numerotelephone) {
		this.numeroTelephone = numerotelephone;
	}
	public String getMailClient() {
		return this.mailClient;
	}
	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}
	
}
