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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Personnel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idPersonnel;
	private String matricule;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private Date dateNaissance;
	private String lieuNaissance;
	private String sexe;
	private int nbreEnfant;
	private Date dateEmbauche;
	private String photo;
	@ManyToMany
	@JoinTable(name="vehicule_Personnel", joinColumns=
	                    @JoinColumn(name="idPersonnel"),
	                    inverseJoinColumns=@JoinColumn(name="idVehicule"))		
	private Collection<Vehicule> vehicules;
	@ManyToOne
	@JoinColumn(name="idprofil")
	private ProfilPersonnel profilPersonnel;
	@OneToMany(mappedBy="personnel")
	private Collection<DiplomePerso> diplomePersos;
	@ManyToOne
	@JoinColumn(name="CODE_EMP_SUP")
	private Personnel personnel;
	@ManyToOne
	@JoinColumn(name="idSituation")
	private SituationMatrimonialePersonnel matrimonialePersonnel;
	@ManyToOne
	@JoinColumn(name="idContrat")
	private ContratPersonnel contratPersonnel;
	@OneToMany(mappedBy="personnel")
	private Collection<Conge> conges;
	@OneToMany(mappedBy="personnel")
	private Collection<Permis> permis;
	private boolean etat;
	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personnel(String matricule, String nom, String prenom, String email, String telephone, Date dateNaissance,
			String lieuNaissance, String sexe, int nbreEnfant, Date dateEmbauche, String photo) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.nbreEnfant = nbreEnfant;
		this.dateEmbauche = dateEmbauche;
		this.photo = photo;
	}
	public Long getIdPersonnel() {
		return idPersonnel;
	}
	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getNbreEnfant() {
		return nbreEnfant;
	}
	public void setNbreEnfant(int nbreEnfant) {
		this.nbreEnfant = nbreEnfant;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Collection<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(Collection<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	public ProfilPersonnel getProfilPersonnel() {
		return profilPersonnel;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Collection<Permis> getPermis() {
		return permis;
	}
	public void setPermis(Collection<Permis> permis) {
		this.permis = permis;
	}
	public void setProfilPersonnel(ProfilPersonnel profilPersonnel) {
		this.profilPersonnel = profilPersonnel;
	}
	public Collection<DiplomePerso> getDiplomePersos() {
		return diplomePersos;
	}
	public void setDiplomePersos(Collection<DiplomePerso> diplomePersos) {
		this.diplomePersos = diplomePersos;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public SituationMatrimonialePersonnel getMatrimonialePersonnel() {
		return matrimonialePersonnel;
	}
	public void setMatrimonialePersonnel(SituationMatrimonialePersonnel matrimonialePersonnel) {
		this.matrimonialePersonnel = matrimonialePersonnel;
	}
	public ContratPersonnel getContratPersonnel() {
		return contratPersonnel;
	}
	public void setContratPersonnel(ContratPersonnel contratPersonnel) {
		this.contratPersonnel = contratPersonnel;
	}
	public Collection<Conge> getConges() {
		return conges;
	}
	public void setConges(Collection<Conge> conges) {
		this.conges = conges;
	}
	
}
