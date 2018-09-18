package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypeConge implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	private String libelle;
	@OneToMany(mappedBy="typeConge")
	private Collection<Conge> conges;
	public TypeConge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeConge(String libelle) {
		super();
		this.libelle = libelle;
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
	public Collection<Conge> getConges() {
		return conges;
	}
	public void setConges(Collection<Conge> conges) {
		this.conges = conges;
	}

}
