package org.avr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class DetailEntretienVehicule implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetail;
	private String description;
	@ManyToOne
	@JoinColumn(name="numEntretient")
	private EntretienVehicule entretienVehicule;
	public DetailEntretienVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetailEntretienVehicule(String description) {
		super();
		this.description = description;
	}
	public Long getIdDetail() {
		return idDetail;
	}
	public void setIdDetail(Long idDetail) {
		this.idDetail = idDetail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EntretienVehicule getEntretienVehicule() {
		return entretienVehicule;
	}
	public void setEntretienVehicule(EntretienVehicule entretienVehicule) {
		this.entretienVehicule = entretienVehicule;
	}

}
