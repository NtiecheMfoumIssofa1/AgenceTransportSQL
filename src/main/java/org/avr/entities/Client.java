package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)// coe il y'a heritage a la classe client, Single_table spécifie qu'on va save tout les types de compte dans une meme table
@DiscriminatorColumn(name="TYPE_Client",discriminatorType=DiscriminatorType.STRING,length=10)//creation d'une ligne dans la table compte qui va marquer soit un versement(VERS) ou un retrait(RETR) d'ou la proprité lenght =4
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	private String CniClient;
	private String nomClient;
	private String prenomClient;
	private String villeClient;
	private String telephone;
	private String emailClient;
	private String sexe;
	private Date datenaissanceCli;
	@OneToMany(mappedBy="client")
	private Collection<Paiement> paiements;
	@OneToMany(mappedBy="client")
	private Collection<Billet> billets;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String cniClient, String nomClient, String prenomClient, String villeClient, String telephone,
			String emailClient, String sexe, Date datenaissanceCli) {
		super();
		CniClient = cniClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.villeClient = villeClient;
		this.telephone = telephone;
		this.emailClient = emailClient;
		this.sexe = sexe;
		this.datenaissanceCli = datenaissanceCli;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getCniClient() {
		return CniClient;
	}
	public void setCniClient(String cniClient) {
		CniClient = cniClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getVilleClient() {
		return villeClient;
	}
	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Date getDatenaissanceCli() {
		return datenaissanceCli;
	}
	public void setDatenaissanceCli(Date datenaissanceCli) {
		this.datenaissanceCli = datenaissanceCli;
	}
	public Collection<Paiement> getPaiements() {
		return paiements;
	}
	public void setPaiements(Collection<Paiement> paiements) {
		this.paiements = paiements;
	}
	public Collection<Billet> getBillets() {
		return billets;
	}
	public void setBillets(Collection<Billet> billets) {
		this.billets = billets;
	}
	
	

}
