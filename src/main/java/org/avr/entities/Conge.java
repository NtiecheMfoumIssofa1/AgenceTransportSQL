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
public class Conge implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConge;
	private Date dateDepart;
	private Date dateretour;
	@ManyToOne
	@JoinColumn(name="idPersonnel")
	private Personnel personnel;
	@ManyToOne
	@JoinColumn(name="idType")
	private TypeConge typeConge;
	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conge(Date dateDepart, Date dateretour) {
		super();
		this.dateDepart = dateDepart;
		this.dateretour = dateretour;
	}
	public Long getIdConge() {
		return idConge;
	}
	public void setIdConge(Long idConge) {
		this.idConge = idConge;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateretour() {
		return dateretour;
	}
	public void setDateretour(Date dateretour) {
		this.dateretour = dateretour;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public TypeConge getTypeConge() {
		return typeConge;
	}
	public void setTypeConge(TypeConge typeConge) {
		this.typeConge = typeConge;
	}
	
	

}
