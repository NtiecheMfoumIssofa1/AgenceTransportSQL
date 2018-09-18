package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trajet implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtrajet;
	private String description;
	private Date heurDepart;
	private Date heurArrivee;
	@OneToMany(mappedBy="trajet")
	private Collection<Billet> billets;
	@ManyToMany
	@JoinTable(name="Tarif_Trajet", joinColumns=
	   @JoinColumn(name="idtrajet"),
	   inverseJoinColumns=@JoinColumn(name="idtarif"))/* jointure entre deux table. mais on peut aussi laisser @ManyToMany qui génère la table par defaut(deconseillé)*/
	private Collection<Tarif> tarifs;
	@OneToMany(mappedBy="trajet")
	private Collection<Stationnement> stationnements;
	@ManyToMany
	@JoinTable(name="Gare_Trajet", joinColumns=
	   @JoinColumn(name="idtrajet"),
	   inverseJoinColumns=@JoinColumn(name="idGare"))
	private Collection<GareRoutiere> gareRoutieres;
	@ManyToMany(mappedBy="trajets")
	private Collection<Vehicule> vehicules;
	private boolean etat;
	public Trajet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trajet(String description, Date heurDepart, Date heurArrivee) {
		super();
		this.description = description;  
		this.heurDepart = heurDepart;
		this.heurArrivee = heurArrivee;
	}
	public Long getIdtrajet() {
		return idtrajet;
	}
	public void setIdtrajet(Long idtrajet) {
		this.idtrajet = idtrajet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getHeurDepart() {
		return heurDepart;
	}
	public void setHeurDepart(Date heurDepart) {
		this.heurDepart = heurDepart;
	}
	public Date getHeurArrivee() {
		return heurArrivee;
	}
	public void setHeurArrivee(Date heurArrivee) {
		this.heurArrivee = heurArrivee;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	@JsonIgnore
	public Collection<Billet> getBillets() {
		return billets;
	}
	@JsonSetter
	public void setBillets(Collection<Billet> billets) {
		this.billets = billets;
	}
	@JsonIgnore
	public Collection<Tarif> getTarifs() {
		return tarifs;
	}
	@JsonSetter
	public void setTarifs(Collection<Tarif> tarifs) {
		this.tarifs = tarifs;
	}
	@JsonIgnore
	public Collection<Stationnement> getStationnements() {
		return stationnements;
	}
	@JsonSetter
	public void setStationnements(Collection<Stationnement> stationnements) {
		this.stationnements = stationnements;
	}
	@JsonIgnore
	public Collection<GareRoutiere> getGareRoutieres() {
		return gareRoutieres;
	}
	@JsonSetter
	public void setGareRoutieres(Collection<GareRoutiere> gareRoutieres) {
		this.gareRoutieres = gareRoutieres;
	}
	public Collection<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(Collection<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	
}
