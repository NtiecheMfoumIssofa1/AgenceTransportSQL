package org.avr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ChambreHotel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idChbre;
	private String description;
	@ManyToOne
	@JoinColumn(name="idHotel")
	private Hotel hotel;
	@ManyToOne
	@JoinColumn(name="idType")
	private TypeChambre typeChambre;
	public ChambreHotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChambreHotel(String description) {
		super();
		this.description = description;
	}
	public Long getIdChbre() {
		return idChbre;
	}
	public void setIdChbre(Long idChbre) {
		this.idChbre = idChbre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public TypeChambre getTypeChambre() {
		return typeChambre;
	}
	public void setTypeChambre(TypeChambre typeChambre) {
		this.typeChambre = typeChambre;
	}
    
}
