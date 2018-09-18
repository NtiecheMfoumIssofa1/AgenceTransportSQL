package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TypeVehicule implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTypeVehicule; 
	private String codeTypeVehicule;
	private String libelleTypeVehicule;
	private String photoTypeVehicule;
	@OneToMany(mappedBy="typeVehicule")
	private Collection<Vehicule> vehicules;
	private boolean etat;
	public TypeVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeVehicule(String codeTypeVehicule, String libelleTypeVehicule, String photoTypeVehicule) {
		super();
		this.codeTypeVehicule = codeTypeVehicule;
		this.libelleTypeVehicule = libelleTypeVehicule;
		this.photoTypeVehicule = photoTypeVehicule;
	}
	public Long getIdTypeVehicule() {
		return idTypeVehicule;
	}
	public void setIdTypeVehicule(Long idTypeVehicule) {
		this.idTypeVehicule = idTypeVehicule;
	}
	public String getCodeTypeVehicule() {
		return codeTypeVehicule;
	}
	public void setCodeTypeVehicule(String codeTypeVehicule) {
		this.codeTypeVehicule = codeTypeVehicule;
	}
	public String getLibelleTypeVehicule() {
		return libelleTypeVehicule;
	}
	public void setLibelleTypeVehicule(String libelleTypeVehicule) {
		this.libelleTypeVehicule = libelleTypeVehicule;
	}
	public String getPhotoTypeVehicule() {
		return photoTypeVehicule;
	}
	public void setPhotoTypeVehicule(String photoTypeVehicule) {
		this.photoTypeVehicule = photoTypeVehicule;
	}
	public Collection<Vehicule> getVehicules() {
		return vehicules;
	}
	@JsonIgnore
	public void setVehicules(Collection<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	@JsonSetter
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}

}
