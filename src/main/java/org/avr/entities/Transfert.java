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
@Entity
public class Transfert implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTransfert;
	private String codeTransfert;
	private double montant;
	private boolean statut;
	private String remarque;
	@ManyToOne
	@JoinColumn(name="login")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy="transfert")
	private Collection<BordereauTransfert> bordereauTransferts;
	public Transfert() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transfert(String codeTransfert, double montant, boolean statut, String remarque) {
		super();
		this.codeTransfert = codeTransfert;
		this.montant = montant;
		this.statut = statut;
		this.remarque = remarque;
	}
	public Long getIdTransfert() {
		return idTransfert;
	}
	public void setIdTransfert(Long idTransfert) {
		this.idTransfert = idTransfert;
	}
	public String getCodeTransfert() {
		return codeTransfert;
	}
	public void setCodeTransfert(String codeTransfert) {
		this.codeTransfert = codeTransfert;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	
	public Collection<BordereauTransfert> getBordereauTransferts() {
		return bordereauTransferts;
	}
	public void setBordereauTransferts(Collection<BordereauTransfert> bordereauTransferts) {
		this.bordereauTransferts = bordereauTransferts;
	}
	

}
