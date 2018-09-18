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
public class Fournisseur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numfournisseur;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String raisonSociale;
	private String ville;
	private String fax;
	private String description;
	@OneToMany(mappedBy="fournisseur")
	private Collection<OperationsVehicule> operationsVehicules;
	@OneToMany(mappedBy="fournisseur")
	private Collection<EntretienVehicule> entretienVehicules;
	@ManyToOne
	@JoinColumn(name="fournisseurs")
	private TypeFournisseur typeFournisseur;
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(String nom, String prenom, String email, String telephone, String raisonSociale, String ville,
			String fax, String description) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.raisonSociale = raisonSociale;
		this.ville = ville;
		this.fax = fax;
		this.description = description;
	}
	public Long getNumfournisseur() {
		return numfournisseur;
	}
	public void setNumfournisseur(Long numfournisseur) {
		this.numfournisseur = numfournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<OperationsVehicule> getOperationsVehicules() {
		return operationsVehicules;
	}
	public void setOperationsVehicules(Collection<OperationsVehicule> operationsVehicules) {
		this.operationsVehicules = operationsVehicules;
	}
	public Collection<EntretienVehicule> getEntretienVehicules() {
		return entretienVehicules;
	}
	public void setEntretienVehicules(Collection<EntretienVehicule> entretienVehicules) {
		this.entretienVehicules = entretienVehicules;
	}
	public TypeFournisseur getTypeFournisseur() {
		return typeFournisseur;
	}
	public void setTypeFournisseur(TypeFournisseur typeFournisseur) {
		this.typeFournisseur = typeFournisseur;
	}

}
