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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Vehicule implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVehicule;
	private String numSerie;
	private String marque;
	private String model;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate miseEnService;
	private boolean actif;
	private double capaciteReservoir;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate anneefabrication;
	private String descriptionVehicule;
	private Long nbreplace;
	private Float kilometrage;
	@OneToMany(mappedBy="vehicules")
	private Collection<VehiculOP> vehiculOP;
	@ManyToMany(mappedBy="vehicules")
	private Collection< Personnel> personnels;
	@ManyToMany(mappedBy="vehicules")
	private Collection<VisiteTechnique> visiteTechniques;
	@ManyToMany(mappedBy="vehicules")
	private Collection<Taxe> taxes;
	@ManyToMany
	@JoinTable(name="Assurance_Vehicule",joinColumns=
	@JoinColumn(name="idVehicule"),
	inverseJoinColumns=@JoinColumn(name="numAssurance"))
	private Collection<Assurance> assurances;
	@OneToMany(mappedBy="vehicules")
	private Collection<EntretienVehicule> entretienVehicules;
	@ManyToOne
	@JoinColumn(name="idCarb")
	private Carburant carburants;
	@ManyToOne
	@JoinColumn(name="idDep")
	private Departement departement;
	@ManyToOne
	@JoinColumn(name="idTypeVehicule")
	private TypeVehicule typeVehicule;
	@ManyToMany
	@JoinTable(name="vehicule_Trajet", joinColumns=
			   @JoinColumn(name="idVehicule"),
			   inverseJoinColumns=@JoinColumn(name="idtrajet"))
	private Collection<Trajet> trajets;
	private boolean etat;
	
	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicule(String numSerie, String marque, String model, LocalDate miseEnService, boolean actif,
			double capaciteReservoir, LocalDate anneefabrication, String descriptionVehicule, Long nbreplace,
			Float kilometrage) {
		super();
		this.numSerie = numSerie;
		this.marque = marque;
		this.model = model;
		this.miseEnService = miseEnService;
		this.actif = actif;
		this.capaciteReservoir = capaciteReservoir;
		this.anneefabrication = anneefabrication;
		this.descriptionVehicule = descriptionVehicule;
		this.nbreplace = nbreplace;
		this.kilometrage = kilometrage;
	}
	public Long getIdVehicule() {
		return idVehicule;
	}
	public void setIdVehicule(Long idVehicule) {
		this.idVehicule = idVehicule;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getMiseEnService() {
		return miseEnService;
	}
	public void setMiseEnService(LocalDate miseEnService) {
		this.miseEnService = miseEnService;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public double getCapaciteReservoir() {
		return capaciteReservoir;
	}
	public void setCapaciteReservoir(double capaciteReservoir) {
		this.capaciteReservoir = capaciteReservoir;
	}
	public LocalDate getAnneefabrication() {
		return anneefabrication;
	}
	public void setAnneefabrication(LocalDate anneefabrication) {
		this.anneefabrication = anneefabrication;
	}
	public String getDescriptionVehicule() {
		return descriptionVehicule;
	}
	public void setDescriptionVehicule(String descriptionVehicule) {
		this.descriptionVehicule = descriptionVehicule;
	}
	public Long getNbreplace() {
		return nbreplace;
	}
	public void setNbreplace(Long nbreplace) {
		this.nbreplace = nbreplace;
	}
	public Float getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(Float kilometrage) {
		this.kilometrage = kilometrage;
	}
	@JsonIgnore
	public Collection<VehiculOP> getVehiculOP() {
		return vehiculOP;
	}
	@JsonSetter
	public void setVehiculOP(Collection<VehiculOP> vehiculOP) {
		this.vehiculOP = vehiculOP;
	}
	@JsonIgnore
	public Collection<VisiteTechnique> getVisiteTechniques() {
		return visiteTechniques;
	}
	@JsonIgnore
	public Collection<Trajet> getTrajets() {
		return trajets;
	}
	@JsonSetter
	public void setTrajets(Collection<Trajet> trajets) {
		this.trajets = trajets;
	}
	@JsonIgnore
	public boolean isEtat() {
		return etat;
	}
	@JsonSetter
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	@JsonSetter
	public void setVisiteTechniques(Collection<VisiteTechnique> visiteTechniques) {
		this.visiteTechniques = visiteTechniques;
	}
	@JsonIgnore
	public Collection<Taxe> getTaxes() {
		return taxes;
	}
	@JsonSetter
	public void setTaxes(Collection<Taxe> taxes) {
		this.taxes = taxes;
	}
	@JsonIgnore
	public Collection<Assurance> getAssurances() {
		return assurances;
	}
	@JsonSetter
	public void setAssurances(Collection<Assurance> assurances) {
		this.assurances = assurances;
	}
	@JsonIgnore
	public Collection<EntretienVehicule> getEntretienVehicules() {
		return entretienVehicules;
	}
	@JsonSetter
	public void setEntretienVehicules(Collection<EntretienVehicule> entretienVehicules) {
		this.entretienVehicules = entretienVehicules;
	}
	@JsonIgnore
	public Carburant getCarburants() {
		return carburants;
	}
	@JsonSetter
	public void setCarburants(Carburant carburants) {
		this.carburants = carburants;
	}
	@JsonIgnore
	public Departement getDepartement() {
		return departement;
	}
	@JsonSetter
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	@JsonIgnore
	public TypeVehicule getTypeVehicule() {
		return typeVehicule;
	}
	@JsonSetter
	public void setTypeVehicule(TypeVehicule typeVehicule) {
		this.typeVehicule = typeVehicule;
	}
	@JsonIgnore
	public Collection<Personnel> getPersonnels() {
		return personnels;
	}
	@JsonSetter
	public void setPersonnels(Collection<Personnel> personnels) {
		this.personnels = personnels;
	}
	

}
