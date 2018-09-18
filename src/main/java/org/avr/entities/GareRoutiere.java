package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public  class GareRoutiere implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGare;
	private String description;
	private String telephone;
	private String mail;
	private String rueGare;
	@ManyToMany(mappedBy="gareRoutieres")
	private Collection<Trajet> trajets;
	@ManyToOne
	@JoinColumn(name="idVille")
	private Ville ville;
	private boolean etat;
	public GareRoutiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GareRoutiere(String description, String telephone, String mail) {
		super();
		this.description = description;
		this.telephone = telephone;
		this.mail = mail;
	}
	public Long getIdGare() {
		return idGare;
	}
	public void setIdGare(Long idGare) {
		this.idGare = idGare;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getRueGare() {
		return rueGare;
	}
	public void setRueGare(String rueGare) {
		this.rueGare = rueGare;
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
	public Collection<Trajet> getTrajets() {
		return trajets;
	}
	@JsonSetter
	public void setTrajets(Collection<Trajet> trajets) {
		this.trajets = trajets;
	}
	@JsonIgnore
	public Ville getVille() {
		return ville;
	}
	@JsonSetter
	public void setVille(Ville ville) {
		this.ville = ville;
	}
}
