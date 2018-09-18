package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class VehiculOP implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numOp;
	private Date dateOperation;
	@ManyToOne
	@JoinColumn(name="numOperation")
	private OperationsVehicule operationsVehicules;
	@ManyToOne
	@JoinColumn(name="idVehicule")
	private Vehicule vehicules;
	public VehiculOP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VehiculOP(Date dateOperation) {
		super();
		this.dateOperation = dateOperation;
	}
	
	public Long getNumOp() {
		return numOp;
	}
	public void setNumOp(Long numOp) {
		this.numOp = numOp;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public OperationsVehicule getOperationsVehicules() {
		return operationsVehicules;
	}
	public void setOperationsVehicules(OperationsVehicule operationsVehicules) {
		this.operationsVehicules = operationsVehicules;
	}
	public Vehicule getVehicules() {
		return vehicules;
	}
	public void setVehicules(Vehicule vehicules) {
		this.vehicules = vehicules;
	}
	

}
