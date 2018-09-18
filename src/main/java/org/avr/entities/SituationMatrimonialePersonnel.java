package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class SituationMatrimonialePersonnel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSituation;
	private String libelle;
	@OneToMany(mappedBy="matrimonialePersonnel")
	private Collection<Personnel> personnels;
	public SituationMatrimonialePersonnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SituationMatrimonialePersonnel(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Long getIdSituation() {
		return idSituation;
	}
	public void setIdSituation(Long idSituation) {
		this.idSituation = idSituation;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Collection<Personnel> personnels) {
		this.personnels = personnels;
	}

}
