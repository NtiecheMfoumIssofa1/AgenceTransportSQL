package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class DiplomePersonnel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDiplome;
	private String referenceDiplome;
	@OneToMany(mappedBy="diplomePersonnel")
	private Collection<DiplomePerso> diplomePersos;
	public DiplomePersonnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiplomePersonnel(String referenceDiplome) {
		super();
		this.referenceDiplome = referenceDiplome;
	}
	public Long getIdDiplome() {
		return idDiplome;
	}
	public void setIdDiplome(Long idDiplome) {
		this.idDiplome = idDiplome;
	}
	public String getReferenceDiplome() {
		return referenceDiplome;
	}
	public void setReferenceDiplome(String referenceDiplome) {
		this.referenceDiplome = referenceDiplome;
	}
	public Collection<DiplomePerso> getDiplomePersos() {
		return diplomePersos;
	}
	public void setDiplomePersos(Collection<DiplomePerso> diplomePersos) {
		this.diplomePersos = diplomePersos;
	}
	

}
