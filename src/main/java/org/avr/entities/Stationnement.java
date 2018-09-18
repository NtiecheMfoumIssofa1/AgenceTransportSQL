package org.avr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class Stationnement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStationnement;
	private String description;
	@ManyToOne
	@JoinColumn(name="idtrajet")
    private Trajet trajet;
	private boolean etat;
	public Stationnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stationnement(String description) {
		super();
		this.description = description;
	}
	public Long getIdStationnement() {
		return idStationnement;
	}
	public void setIdStationnement(Long idStationnement) {
		this.idStationnement = idStationnement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonIgnore
	public boolean isEtat() {
		return etat;
	}
	@JsonSetter
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	@JsonIgnore
	public Trajet getTrajet() {
		return trajet;
	}
	@JsonSetter
	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	

}
