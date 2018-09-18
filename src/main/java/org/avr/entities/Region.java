package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Region implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRegion;
	private String libelleRegion;
	@OneToMany(mappedBy="region")
	private Collection<Ville> villes;
	@ManyToOne
	@JoinColumn(name="idPays")
	private Pays pays;
	private boolean etat;
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Region(String libelleRegion) {
		super();
		this.libelleRegion = libelleRegion;
	}
	public Long getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(Long idRegion) {
		this.idRegion = idRegion;
	}
	public String getLibelleRegion() {
		return libelleRegion;
	}
	public void setLibelleRegion(String libelleRegion) {
		this.libelleRegion = libelleRegion;
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
	public Collection<Ville> getVilles() {
		return villes;
	}
	@JsonSetter
	public void setVilles(Collection<Ville> villes) {
		this.villes = villes;
	}
	@JsonIgnore
	public Pays getPays() {
		return pays;
	}
	@JsonSetter
	public void setPays(Pays pays) {
		this.pays = pays;
	}

}
