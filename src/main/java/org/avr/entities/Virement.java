package org.avr.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@DiscriminatorValue("Virement")
public class Virement extends Paiement{
	private String description;
	private String numCpteExpediteur; 
	private String numCpteDestinataire;
	@ManyToOne
	@JoinColumn(name="idType")
	private TypeVirement typeVirement;
	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Virement(String motif, Date datePaiement, String description, String numCpteExpediteur,
			String numCpteDestinataire) {
		super(motif, datePaiement);
		this.description = description;
		this.numCpteExpediteur = numCpteExpediteur;
		this.numCpteDestinataire = numCpteDestinataire;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNumCpteExpediteur() {
		return numCpteExpediteur;
	}
	public void setNumCpteExpediteur(String numCpteExpediteur) {
		this.numCpteExpediteur = numCpteExpediteur;
	}
	public String getNumCpteDestinataire() {
		return numCpteDestinataire;
	}
	public void setNumCpteDestinataire(String numCpteDestinataire) {
		this.numCpteDestinataire = numCpteDestinataire;
	}
	public TypeVirement getTypeVirement() {
		return typeVirement;
	}
	public void setTypeVirement(TypeVirement typeVirement) {
		this.typeVirement = typeVirement;
	}
	

}
