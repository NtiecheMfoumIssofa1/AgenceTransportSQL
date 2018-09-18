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
public class Pays implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPays;
	private String libellePays;
	@OneToMany(mappedBy="pays")
	private Collection<Region> regions; 
	private boolean etat;
	public Pays() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pays(String libellePays, boolean etat) {
		super();
		this.libellePays = libellePays;
		this.etat = etat;
	}

	public Long getIdPays() {
		return idPays;
	}
	public void setIdPays(Long idPays) {
		this.idPays = idPays;
	}
	public String getLibellePays() {
		return libellePays;
	}
	public void setLibellePays(String libellePays) {
		this.libellePays = libellePays;
	}
	@JsonIgnore
	public Collection<Region> getRegions() {
		return regions;
	}
	@JsonSetter
	public void setRegions(Collection<Region> regions) {
		this.regions = regions;
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
