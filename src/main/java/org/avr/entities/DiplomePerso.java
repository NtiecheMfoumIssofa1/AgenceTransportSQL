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
@Entity
public class DiplomePerso implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDiplomePerso;
	private Date dateObtension;
	@ManyToOne
	@JoinColumn(name="idPersonnel")
	private Personnel personnel;
	@ManyToOne
	@JoinColumn(name="idDiplome")
	private DiplomePersonnel diplomePersonnel;
	public DiplomePerso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiplomePerso(Date dateObtension) {
		super();
		this.dateObtension = dateObtension;
	}
	public Long getIdDiplomePerso() {
		return idDiplomePerso;
	}
	public void setIdDiplomePerso(Long idDiplomePerso) {
		this.idDiplomePerso = idDiplomePerso;
	}
	public Date getDateObtension() {
		return dateObtension;
	}
	public void setDateObtension(Date dateObtension) {
		this.dateObtension = dateObtension;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public DiplomePersonnel getDiplomePersonnel() {
		return diplomePersonnel;
	}
	public void setDiplomePersonnel(DiplomePersonnel diplomePersonnel) {
		this.diplomePersonnel = diplomePersonnel;
	}
	

}
