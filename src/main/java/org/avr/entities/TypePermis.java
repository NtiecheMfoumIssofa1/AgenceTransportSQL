package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypePermis implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	private String libelle;
	@OneToMany(mappedBy="typePermis")
	private Collection<Permis> permis;
	public TypePermis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypePermis(String libelle) {
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
	public Collection<Permis> getPermis() {
		return permis;
	}
	public void setPermis(Collection<Permis> permis) {
		this.permis = permis;
	}

} 
