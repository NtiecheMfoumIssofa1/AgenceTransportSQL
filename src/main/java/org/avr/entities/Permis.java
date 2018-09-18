package org.avr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Permis implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPermis;
	private String numPermis;
	private Date datedelivrance;
	private Date dateExpiration;
	private String lieuDelivrance;
	@ManyToOne
	@JoinColumn(name="idPersonnel")
	private Personnel personnel;
	@ManyToOne
	@JoinColumn(name="idType")
	private TypePermis typePermis;
	public Permis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permis(String numPermis, Date datedelivrance, Date dateExpiration, String lieuDelivrance) {
		super();
		this.numPermis = numPermis;
		this.datedelivrance = datedelivrance;
		this.dateExpiration = dateExpiration;
		this.lieuDelivrance = lieuDelivrance;
	}
	public Long getIdPermis() {
		return idPermis;
	}
	public void setIdPermis(Long idPermis) {
		this.idPermis = idPermis;
	}
	public String getNumPermis() {
		return numPermis;
	}
	public void setNumPermis(String numPermis) {
		this.numPermis = numPermis;
	}
	public Date getDatedelivrance() {
		return datedelivrance;
	}
	public void setDatedelivrance(Date datedelivrance) {
		this.datedelivrance = datedelivrance;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public String getLieuDelivrance() {
		return lieuDelivrance;
	}
	public void setLieuDelivrance(String lieuDelivrance) {
		this.lieuDelivrance = lieuDelivrance;
	}
	public TypePermis getTypePermis() {
		return typePermis;
	}
	public void setTypePermis(TypePermis typePermis) {
		this.typePermis = typePermis;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	

}
