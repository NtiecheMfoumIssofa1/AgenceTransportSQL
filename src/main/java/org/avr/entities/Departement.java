package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Departement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDep;
	private String codeDep;
	private String libelleDep;
	@OneToMany(mappedBy="departement")
	private Collection<Vehicule> vehicules;
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(String codeDep, String libelleDep) {
		super();
		this.codeDep = codeDep;
		this.libelleDep = libelleDep;
	}
	public Long getIdDep() {
		return idDep;
	}
	public void setIdDep(Long idDep) {
		this.idDep = idDep;
	}
	public String getCodeDep() {
		return codeDep;
	}
	public void setCodeDep(String codeDep) {
		this.codeDep = codeDep;
	}
	public String getLibelleDep() {
		return libelleDep;
	}
	public void setLibelleDep(String libelleDep) {
		this.libelleDep = libelleDep;
	}
	public Collection<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(Collection<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
 
}
