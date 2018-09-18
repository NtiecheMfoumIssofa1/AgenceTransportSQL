package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Garage implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGarage;
	private String libelle;
	private String telephone;
	private String localisation;
	@OneToMany(mappedBy="garage")
	private Collection<EntretienVehicule> entretienVehicules;
	public Garage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Garage(String libelle, String telephone, String localisation) {
		super();
		this.libelle = libelle;
		this.telephone = telephone;
		this.localisation = localisation;
	}
	public Long getIdGarage() {
		return idGarage;
	}
	public void setIdGarage(Long idGarage) {
		this.idGarage = idGarage;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public Collection<EntretienVehicule> getEntretienVehicules() {
		return entretienVehicules;
	}
	public void setEntretienVehicules(Collection<EntretienVehicule> entretienVehicules) {
		this.entretienVehicules = entretienVehicules;
	}

}
