package org.avr.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("location")
public class LocationVehicule extends OperationsVehicule{
	private double prixLocation;
	private Date dateFinLocation;
	public LocationVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocationVehicule(Date dateoperation, double prixLocation, Date dateFinLocation) {
		super(dateoperation);
		this.prixLocation = prixLocation;
		this.dateFinLocation = dateFinLocation;
	}
	public double getPrixLocation() {
		return prixLocation;
	}
	public void setPrixLocation(double prixLocation) {
		this.prixLocation = prixLocation;
	}
	public Date getDateFinLocation() {
		return dateFinLocation;
	}
	public void setDateFinLocation(Date dateFinLocation) {
		this.dateFinLocation = dateFinLocation;
	}
	

}
