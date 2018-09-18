package org.avr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Billet implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbillet;
	private Long numPlace;
	private double reduction;
	private Date dateEdition;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	@ManyToOne
	@JoinColumn(name="idtrajet")
	private Trajet trajet;
	public Billet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Billet(Long numPlace, double reduction, Date dateEdition) {
		super();
		this.numPlace = numPlace;
		this.reduction = reduction;
		this.dateEdition = dateEdition;
	}
	public Long getIdbillet() {
		return idbillet;
	}
	public void setIdbillet(Long idbillet) {
		this.idbillet = idbillet;
	}
	public Long getNumPlace() {
		return numPlace;
	}
	public void setNumPlace(Long numPlace) {
		this.numPlace = numPlace;
	}
	public double getReduction() {
		return reduction;
	}
	public void setReduction(double reduction) {
		this.reduction = reduction;
	}
	public Date getDateEdition() {
		return dateEdition;
	}
	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Trajet getTrajet() {
		return trajet;
	}
	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	

}
