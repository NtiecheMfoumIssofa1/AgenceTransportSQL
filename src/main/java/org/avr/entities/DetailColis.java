package org.avr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class DetailColis implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetail;
	private String description;
	private double prix;
	@ManyToOne
	@JoinColumn(name="idColis")
	private Colis colis;
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit;
	public DetailColis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetailColis(String description, double prix) {
		super();
		this.description = description;
		this.prix = prix;
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
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Colis getColis() {
		return colis;
	}
	public void setColis(Colis colis) {
		this.colis = colis;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
