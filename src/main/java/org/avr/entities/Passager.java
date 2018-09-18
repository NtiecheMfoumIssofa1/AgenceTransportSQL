package org.avr.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("Passager")
public class Passager extends Client {
	private String telUrgenceOrigine;
	private String telUrgenceDestination;
	public Passager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passager(String cniClient, String nomClient, String prenomClient, String villeClient, String telephone,
			String emailClient, String sexe, Date datenaissanceCli, String telUrgenceOrigine,
			String telUrgenceDestination) {
		super(cniClient, nomClient, prenomClient, villeClient, telephone, emailClient, sexe, datenaissanceCli);
		this.telUrgenceOrigine = telUrgenceOrigine;
		this.telUrgenceDestination = telUrgenceDestination;
	}
	public String getTelUrgenceOrigine() {
		return telUrgenceOrigine;
	}
	public void setTelUrgenceOrigine(String telUrgenceOrigine) {
		this.telUrgenceOrigine = telUrgenceOrigine;
	}
	public String getTelUrgenceDestination() {
		return telUrgenceDestination;
	}
	public void setTelUrgenceDestination(String telUrgenceDestination) {
		this.telUrgenceDestination = telUrgenceDestination;
	}
	
}
