package org.avr.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@DiscriminatorValue("Versement")
public class Versement extends Paiement {
	private String description;
	private String numCpteDestinataire; 
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Versement(String motif, Date datePaiement, String description, String numCpteDestinataire) {
		super(motif, datePaiement);
		this.description = description;
		this.numCpteDestinataire = numCpteDestinataire;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNumCpteDestinataire() {
		return numCpteDestinataire;
	}
	public void setNumCpteDestinataire(String numCpteDestinataire) {
		this.numCpteDestinataire = numCpteDestinataire;
	}
	

}
