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
public class FactureEntretien implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numFacture;
	private Date dateFacture;
	private double montant;
	@ManyToOne
	@JoinColumn(name="numEntretient")
	private EntretienVehicule entretienVehicule;
	public FactureEntretien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FactureEntretien(Date dateFacture, double montant) {
		super();
		this.dateFacture = dateFacture;
		this.montant = montant;
	}
	public Long getNumFacture() {
		return numFacture;
	}
	public void setNumFacture(Long numFacture) {
		this.numFacture = numFacture;
	}
	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public EntretienVehicule getEntretienVehicule() {
		return entretienVehicule;
	}
	public void setEntretienVehicule(EntretienVehicule entretienVehicule) {
		this.entretienVehicule = entretienVehicule;
	}
	

}
