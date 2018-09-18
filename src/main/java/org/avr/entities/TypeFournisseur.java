package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypeFournisseur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idType;
	private String codeFournisseur;
	private String libelle;
	@OneToMany(mappedBy="typeFournisseur")
	private Collection<Fournisseur> fournisseurs;
	public TypeFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeFournisseur(String codeFournisseur, String libelle) {
		super();
		this.codeFournisseur = codeFournisseur;
		this.libelle = libelle;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getCodeFournisseur() {
		return codeFournisseur;
	}
	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(Collection<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

}
