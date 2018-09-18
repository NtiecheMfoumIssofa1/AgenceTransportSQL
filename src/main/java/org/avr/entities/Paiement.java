package org.avr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)// coe il y'a heritage a la classe compte, Single_table spécifie qu'on va save tout les types de compte dans une meme table
@DiscriminatorColumn(name="TYPE_Paiement",discriminatorType=DiscriminatorType.STRING,length=10)//creation d'une ligne dans la table compte qui va marquer soit un versement(VERS) ou un retrait(RETR) d'ou la proprité lenght =4
public class Paiement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPaiement;
	private String motif;
	private Date datePaiement;  
	@ManyToOne
	@JoinColumn(name="login")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paiement(String motif, Date datePaiement) {
		super();
		this.motif = motif;
		this.datePaiement = datePaiement;
	}
	public Long getIdPaiement() {
		return idPaiement;
	}
	public void setIdPaiement(Long idPaiement) {
		this.idPaiement = idPaiement;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Date getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client; 
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
