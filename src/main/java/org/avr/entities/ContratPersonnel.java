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
public class ContratPersonnel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContrat;
	private Date dateDebut;
	private Date dateFin;
	@OneToMany(mappedBy="contratPersonnel")
	private Collection<Personnel> personnels;
	@ManyToOne
	@JoinColumn(name="contratPersonnels")
	private TypeContrat typeContrat;
	@ManyToOne
	@JoinColumn(name="idMode")
	private ModePaiementContrat  paiementContrat;
	public ContratPersonnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContratPersonnel(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	public Long getIdContrat() {
		return idContrat;
	}
	public void setIdContrat(Long idContrat) {
		this.idContrat = idContrat;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Collection<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Collection<Personnel> personnels) {
		this.personnels = personnels;
	}
	public TypeContrat getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}
	public ModePaiementContrat getPaiementContrat() {
		return paiementContrat;
	}
	public void setPaiementContrat(ModePaiementContrat paiementContrat) {
		this.paiementContrat = paiementContrat;
	}
 
}
