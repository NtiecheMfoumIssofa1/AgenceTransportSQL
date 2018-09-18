package org.avr.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Carburant implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCarb;
	private String descripltionCarb;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")//formatage de la date du format json
	//@Temporal(TemporalType.DATE)
	private LocalDate dateCarb;
	private double quantiteCarb;
	private double coutCarb;
	private Long kilometredebut;
	private Long kilometreFin;
	private String note;
	@OneToMany(mappedBy="carburants")
	private Collection<Vehicule> vehicules;
	@ManyToMany
	@JoinTable(name="Carburant_ville", joinColumns
	=@JoinColumn(name="idCarb"), inverseJoinColumns=@JoinColumn(name="idVille"))
	private Collection<Ville> villes; 
	private boolean etat;
	public Carburant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Carburant(String descripltionCarb, LocalDate dateCarb, double quantiteCarb, double coutCarb, Long kilometredebut,
			Long kilometreFin, String note) {
		super();
		this.descripltionCarb = descripltionCarb;
		this.dateCarb = dateCarb;
		this.quantiteCarb = quantiteCarb;
		this.coutCarb = coutCarb;
		this.kilometredebut = kilometredebut;
		this.kilometreFin = kilometreFin;
		this.note = note;
	}
	public Long getIdCarb() {
		return idCarb;
	}
	public void setIdCarb(Long idCarb) {
		this.idCarb = idCarb;
	}
	public String getDescripltionCarb() {
		return descripltionCarb;
	}
	public void setDescripltionCarb(String descripltionCarb) {
		this.descripltionCarb = descripltionCarb;
	}
	
	public double getQuantiteCarb() {
		return quantiteCarb;
	}
	public void setQuantiteCarb(double quantiteCarb) {
		this.quantiteCarb = quantiteCarb;
	}
	public double getCoutCarb() {
		return coutCarb;
	}
	public void setCoutCarb(double coutCarb) {
		this.coutCarb = coutCarb;
	}
	public Long getKilometredebut() {
		return kilometredebut;
	}
	public void setKilometredebut(Long kilometredebut) {
		this.kilometredebut = kilometredebut;
	}
	public Long getKilometreFin() {
		return kilometreFin;
	}
	public void setKilometreFin(Long kilometreFin) {
		this.kilometreFin = kilometreFin;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public LocalDate getDateCarb() {
		return dateCarb;
	}
	public void setDateCarb(LocalDate dateCarb) {
		this.dateCarb = dateCarb;
	}
	@JsonIgnore
	public Collection<Vehicule> getVehicules() {
		return vehicules;
	}
	@JsonSetter
	public void setVehicules(Collection<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	@JsonIgnore
	public Collection<Ville> getVilles() {
		return villes;
	}
	@JsonSetter
	public void setVilles(Collection<Ville> villes) {
		this.villes = villes;
	}
	@JsonIgnore
	public boolean isEtat() {
		return etat;
	} 
	@JsonSetter
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	

}
