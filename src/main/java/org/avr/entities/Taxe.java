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
public class Taxe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numTaxe;
	private LocalDate dateCirculation;
	private LocalDate expirationtaxe;
	private int rappelAvantJour;
	private String note;
	private String description;
	private Double montant;
	@ManyToMany
	@JoinTable(name="vehicule_taxe",joinColumns=
	@JoinColumn(name="numTaxe"),inverseJoinColumns=
	@JoinColumn(name="idVehicule"))
	private Collection<Vehicule> vehicules;
	private boolean etat;
	public Taxe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Taxe(LocalDate dateCirculation, LocalDate expirationtaxe, int rappelAvantJour, String note,
			String description, Double montant, boolean etat) {
		super();
		this.dateCirculation = dateCirculation;
		this.expirationtaxe = expirationtaxe;
		this.rappelAvantJour = rappelAvantJour;
		this.note = note;
		this.description = description;
		this.montant = montant;
		this.etat = etat;
	}

	public Long getNumTaxe() {
		return numTaxe;
	}
	public void setNumTaxe(Long numTaxe) {
		this.numTaxe = numTaxe;
	}
	public LocalDate getDateCirculation() {
		return dateCirculation;
	}
	public void setDateCirculation(LocalDate dateCirculation) {
		this.dateCirculation = dateCirculation;
	}
	public LocalDate getExpirationtaxe() {
		return expirationtaxe;
	}
	public void setExpirationtaxe(LocalDate expirationtaxe) {
		this.expirationtaxe = expirationtaxe;
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
	@JsonIgnore
	public boolean isEtat() {
		return etat;
	}
	@JsonSetter
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
