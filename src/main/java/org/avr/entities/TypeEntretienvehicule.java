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
public class TypeEntretienvehicule implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEntretient;
	private String libelleEntretient;
	@OneToMany(mappedBy="typeEntretienvehicule")
	private Collection<EntretienVehicule> entretienVehicules;
	public TypeEntretienvehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeEntretienvehicule(String libelleEntretient) {
		super();
		this.libelleEntretient = libelleEntretient;
	}
	public Long getIdEntretient() {
		return idEntretient;
	}
	public void setIdEntretient(Long idEntretient) {
		this.idEntretient = idEntretient;
	}
	public String getLibelleEntretient() {
		return libelleEntretient;
	}
	public void setLibelleEntretient(String libelleEntretient) {
		this.libelleEntretient = libelleEntretient;
	}
	public Collection<EntretienVehicule> getEntretienVehicules() {
		return entretienVehicules;
	}
	public void setEntretienVehicules(Collection<EntretienVehicule> entretienVehicules) {
		this.entretienVehicules = entretienVehicules;
	}

}
