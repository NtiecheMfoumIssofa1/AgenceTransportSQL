package org.avr.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Achat")
public class AchatVehicule  extends OperationsVehicule{
	private double prixAchat;
	private Date expirationGarantie;
	public AchatVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AchatVehicule(Date dateoperation, double prixAchat, Date expirationGarantie) {
		super(dateoperation);
		this.prixAchat = prixAchat;
		this.expirationGarantie = expirationGarantie;
	}
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public Date getExpirationGarantie() {
		return expirationGarantie;
	}
	public void setExpirationGarantie(Date expirationGarantie) {
		this.expirationGarantie = expirationGarantie;
	}
	
	
	

}
