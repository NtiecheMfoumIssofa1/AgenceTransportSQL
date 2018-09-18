package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypeHotel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idType;
	private String libelle;
	@OneToMany(mappedBy="typeHotel")
	private Collection<Hotel> hotels;
	public TypeHotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeHotel(String libelle) {
		super();
		this.libelle = libelle;
	}
	public long getIdType() {
		return idType;
	}
	public void setIdType(long idType) {
		this.idType = idType;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(Collection<Hotel> hotels) {
		this.hotels = hotels;
	}

}
