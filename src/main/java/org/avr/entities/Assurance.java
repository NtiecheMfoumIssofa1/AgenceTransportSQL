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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Assurance implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numAssurance;
	private int rappel;
	private String note;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")//formatage de la date du format json
	//@Temporal(TemporalType.DATE)
	private LocalDate dateAssurence;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")//formatage de la date du format json
	//@Temporal(TemporalType.DATE)
	private LocalDate dateExpiration;
	private String lieuAssurance;
	private double montant;
	private boolean etat;
	@ManyToMany(mappedBy="assurances")
	private Collection<Vehicule> vehicules;
	public Assurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assurance(int rappel, String note, LocalDate dateAssurence, LocalDate dateExpiration, String lieuAssurance,
			double montant) {
		super();
		this.rappel = rappel;
		this.note = note;
		this.dateAssurence = dateAssurence;
		this.dateExpiration = dateExpiration;
		this.lieuAssurance = lieuAssurance;
		this.montant = montant;
	}
	public Long getNumAssurance() {
		return numAssurance;
	}
	public void setNumAssurance(Long numAssurance) {
		this.numAssurance = numAssurance;
	}
	public int getRappel() {
		return rappel;
	}
	public void setRappel(int rappel) {
		this.rappel = rappel;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public LocalDate getDateAssurence() {
		return dateAssurence;
	}
	public void setDateAssurence(LocalDate dateAssurence) {
		this.dateAssurence = dateAssurence;
	}
	public LocalDate getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public String getLieuAssurance() {
		return lieuAssurance;
	}
	public void setLieuAssurance(String lieuAssurance) {
		this.lieuAssurance = lieuAssurance;
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
