package org.avr.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class VisiteTechnique implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long numvisite;
     private LocalDate derniereVisite;
     private LocalDate prochaineVisite;
     private int rappelAvantJour;
     private String note;
     private String lieu;
     private double montant;
     private boolean etat;
     @ManyToMany
     @JoinTable(name="vehicule_visite",joinColumns=
     @JoinColumn(name="numvisite"),inverseJoinColumns=
     @JoinColumn(name="idVehicule"))
     private Collection<Vehicule> vehicules;
	public VisiteTechnique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisiteTechnique(LocalDate derniereVisite, LocalDate prochaineVisite, int rappelAvantJour, String note, String lieu,
			double montant) {
		super();
		this.derniereVisite = derniereVisite;
		this.prochaineVisite = prochaineVisite;
		this.rappelAvantJour = rappelAvantJour;
		this.note = note;
		this.lieu = lieu;
		this.montant = montant;
	}
	public Long getNumvisite() {
		return numvisite;
	}
	public void setNumvisite(Long numvisite) {
		this.numvisite = numvisite;
	}
	public LocalDate getDerniereVisite() {
		return derniereVisite;
	}
	public void setDerniereVisite(LocalDate derniereVisite) {
		this.derniereVisite = derniereVisite;
	}
	public LocalDate getProchaineVisite() {
		return prochaineVisite;
	}
	public void setProchaineVisite(LocalDate prochaineVisite) {
		this.prochaineVisite = prochaineVisite;
	}
	public int getRappelAvantJour() {
		return rappelAvantJour;
	}
	public void setRappelAvantJour(int rappelAvantJour) {
		this.rappelAvantJour = rappelAvantJour;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@JsonIgnore
	public boolean isEtat() {
		return etat;
	}
	@JsonSetter
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	@JsonIgnore
	public Collection<Vehicule> getVehicules() {
		return vehicules;
	}
	@JsonSetter
	public void setVehicules(Collection<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	
}
