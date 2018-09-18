package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Produit implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	private String libelle;
	@OneToMany(mappedBy="produit")
	private Collection<DetailColis> detailColis;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<DetailColis> getDetailColis() {
		return detailColis;
	}
	public void setDetailColis(Collection<DetailColis> detailColis) {
		this.detailColis = detailColis;
	}
   
}
