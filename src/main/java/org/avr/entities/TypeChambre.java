package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypeChambre implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	private String libelle;
	private double prix;
	@OneToMany(mappedBy="typeChambre")
	private Collection<ChambreHotel> chambreHotels;
	public TypeChambre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeChambre(String libelle, double prix) {
		super();
		this.libelle = libelle;
		this.prix = prix;
	}
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Collection<ChambreHotel> getChambreHotels() {
		return chambreHotels;
	}
	public void setChambreHotels(Collection<ChambreHotel> chambreHotels) {
		this.chambreHotels = chambreHotels;
	}

}
