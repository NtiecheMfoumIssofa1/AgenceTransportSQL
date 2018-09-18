package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ville implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVille;
	private String libelle;
	@ManyToOne
	@JoinColumn(name="idRegion")
	private Region region;
	@OneToMany(mappedBy="ville")
	private Collection<Hotel> hotels;
	@ManyToMany(mappedBy="villes")
	private Collection<Carburant> carburants; 
	@OneToMany(mappedBy="ville")
	private Collection<GareRoutiere> gares;
	private boolean etat;
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ville(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Long getIdVille() {
		return idVille;
	}
	public void setIdVille(Long idVille) {
		this.idVille = idVille;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	public Region getRegion() {
		return region;
	}
	@JsonSetter
	public void setRegion(Region region) {
		this.region = region;
	}
	@JsonIgnore
	public Collection<Hotel> getHotels() {
		return hotels;
	}
	@JsonSetter
	public void setHotels(Collection<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	@JsonIgnore
	public Collection<GareRoutiere> getGares() {
		return gares;
	}
	@JsonSetter
	public void setGares(Collection<GareRoutiere> gares) {
		this.gares = gares;
	}
	@JsonIgnore
	public Collection<Carburant> getCarburants() {
		return carburants;
	}
	@JsonSetter
	public void setCarburants(Collection<Carburant> carburants) {
		this.carburants = carburants;
	}
	
	
	
}
