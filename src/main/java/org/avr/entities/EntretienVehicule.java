package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class EntretienVehicule implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numEntretient;
	private Date dateEntretient;
	private String note;
	@ManyToOne
	@JoinColumn(name="idVehicule") 
	private Vehicule vehicules;
	@ManyToOne
	@JoinColumn(name="idEntretient")
	private TypeEntretienvehicule typeEntretienvehicule;
	@OneToMany(mappedBy="entretienVehicule")
	private Collection<DetailEntretienVehicule> detailEntretienVehicules ;
	@ManyToOne
	@JoinColumn(name="idGarage")
	private Garage garage;
	@OneToMany(mappedBy="entretienVehicule")
	private Collection<FactureEntretien> factureEntretiens;
	@ManyToOne
	@JoinColumn(name="numfournisseur")
	private Fournisseur fournisseur;
	public EntretienVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EntretienVehicule(Date dateEntretient, String note) {
		super();
		this.dateEntretient = dateEntretient;
		this.note = note;
	}
	public Long getNumEntretient() {
		return numEntretient;
	}
	public void setNumEntretient(Long numEntretient) {
		this.numEntretient = numEntretient;
	}
	public Date getDateEntretient() {
		return dateEntretient;
	}
	public void setDateEntretient(Date dateEntretient) {
		this.dateEntretient = dateEntretient;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Vehicule getVehicules() {
		return vehicules;
	}
	public void setVehicules(Vehicule vehicules) {
		this.vehicules = vehicules;
	}
	public TypeEntretienvehicule getTypeEntretienvehicule() {
		return typeEntretienvehicule;
	}
	public void setTypeEntretienvehicule(TypeEntretienvehicule typeEntretienvehicule) {
		this.typeEntretienvehicule = typeEntretienvehicule;
	}
	public Collection<DetailEntretienVehicule> getDetailEntretienVehicules() {
		return detailEntretienVehicules;
	}
	public void setDetailEntretienVehicules(Collection<DetailEntretienVehicule> detailEntretienVehicules) {
		this.detailEntretienVehicules = detailEntretienVehicules;
	}
	public Garage getGarage() {
		return garage;
	}
	public void setGarage(Garage garage) {
		this.garage = garage;
	}
	public Collection<FactureEntretien> getFactureEntretiens() {
		return factureEntretiens;
	}
	public void setFactureEntretiens(Collection<FactureEntretien> factureEntretiens) {
		this.factureEntretiens = factureEntretiens;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	

}
