package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPreation",discriminatorType=DiscriminatorType.STRING,length=10)
public class OperationsVehicule implements Serializable{
	@Id
	private Long numOperation;
	private Date dateoperation;
	@ManyToOne
	@JoinColumn(name="numfournisseur")
	private Fournisseur fournisseur;
	@OneToMany(mappedBy="operationsVehicules")
	private Collection<VehiculOP> vehiculOP;
	public OperationsVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperationsVehicule(Date dateoperation) {
		super();
		this.dateoperation = dateoperation;
	}
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	public Date getDateoperation() {
		return dateoperation;
	}
	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Collection<VehiculOP> getVehiculOP() {
		return vehiculOP;
	}
	public void setVehiculOP(Collection<VehiculOP> vehiculOP) {
		this.vehiculOP = vehiculOP;
	}
	

}
