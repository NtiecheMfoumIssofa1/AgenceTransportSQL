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
public class ModePaiementContrat implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMode;
	private String libelle;
	@OneToMany(mappedBy="paiementContrat")
	private Collection<ContratPersonnel> contratPersonnels;
	public ModePaiementContrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModePaiementContrat(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Long getIdMode() {
		return idMode;
	}
	public void setIdMode(Long idMode) {
		this.idMode = idMode;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<ContratPersonnel> getContratPersonnels() {
		return contratPersonnels;
	}
	public void setContratPersonnels(Collection<ContratPersonnel> contratPersonnels) {
		this.contratPersonnels = contratPersonnels;
	}

}
