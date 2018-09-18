package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Tarif implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtarif;
	private double prix;
	@ManyToMany(mappedBy="tarifs")
	private Collection<Trajet> trajets;
	public Tarif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tarif(double prix) {
		super();
		this.prix = prix;
	}
	public Long getIdtarif() {
		return idtarif;
	}
	public void setIdtarif(Long idtarif) {
		this.idtarif = idtarif;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Collection<Trajet> getTrajets() {
		return trajets;
	}
	public void setTrajets(Collection<Trajet> trajets) {
		this.trajets = trajets;
	}

}
