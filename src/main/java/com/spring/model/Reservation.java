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
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private int idReservation;
	@Column(name="date_reservation")
	private String dateReservation;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_client")
	private Client client;
	@ManyToOne(optional=false)
	@JoinColumn(name="ligne_reservation")
	private LigneReservation ligneReservation;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public LigneReservation getLigneReservation() {
		return ligneReservation;
	}
	public void setLigneReservation(LigneReservation ligneReservation) {
		this.ligneReservation = ligneReservation;
	}
	

}
