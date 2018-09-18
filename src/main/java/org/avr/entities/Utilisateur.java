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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Utilisateur implements Serializable{
	@Id
	private String login;
	private String password;
	private boolean statut;// active ou non
	@ManyToMany
	@JoinTable(name="Utilisateur_roles")
	private Collection<Role> roles;
	@OneToMany(mappedBy="utilisateur")
	private Collection<Transfert> transferts;
	@OneToMany(mappedBy="utilisateur")
	private Collection<Paiement> paiements;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Utilisateur(String login, String password, boolean statut) {
		super();
		this.login = login;
		this.password = password;
		this.statut = statut;
	}



	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public Collection<Transfert> getTransferts() {
		return transferts;
	}
	public void setTransferts(Collection<Transfert> transferts) { 
		this.transferts = transferts;
	}
	public Collection<Paiement> getPaiements() {
		return paiements;
	}
	public void setPaiements(Collection<Paiement> paiements) {
		this.paiements = paiements;
	}
	
	
	

}
