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
public class Hotel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHotel;
	private String description;
	private String localisationhotel;
	private Date dateArrive;
	private Date dateDepart;
	@ManyToOne
	@JoinColumn(name="idVille")
	private Ville ville;
	@ManyToOne
	@JoinColumn(name="idType")
	private TypeHotel typeHotel;
	@OneToMany(mappedBy="hotel")
	private Collection<ChambreHotel> chambreHotels;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(String description, String localisationhotel, Date dateArrive, Date dateDepart) {
		super();
		this.description = description;
		this.localisationhotel = localisationhotel;
		this.dateArrive = dateArrive;
		this.dateDepart = dateDepart;
	}
	public Long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocalisationhotel() {
		return localisationhotel;
	}
	public void setLocalisationhotel(String localisationhotel) {
		this.localisationhotel = localisationhotel;
	}
	public Date getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public TypeHotel getTypeHotel() {
		return typeHotel;
	}
	public void setTypeHotel(TypeHotel typeHotel) {
		this.typeHotel = typeHotel;
	}
	public Collection<ChambreHotel> getChambreHotels() {
		return chambreHotels;
	}
	public void setChambreHotels(Collection<ChambreHotel> chambreHotels) {
		this.chambreHotels = chambreHotels;
	}
	

}
