package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class ProfilPersonnel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idprofil;
	private String codeprofil;
	private String libelleprofil;
	@OneToMany(mappedBy="profilPersonnel")
	private Collection<Personnel> personnels;
	public ProfilPersonnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfilPersonnel(String codeprofil, String libelleprofil) {
		super();
		this.codeprofil = codeprofil;
		this.libelleprofil = libelleprofil;
	}
	public Long getIdprofil() {
		return idprofil;
	}
	public void setIdprofil(Long idprofil) {
		this.idprofil = idprofil;
	}
	public String getCodeprofil() {
		return codeprofil;
	}
	public void setCodeprofil(String codeprofil) {
		this.codeprofil = codeprofil;
	}
	public String getLibelleprofil() {
		return libelleprofil;
	}
	public void setLibelleprofil(String libelleprofil) {
		this.libelleprofil = libelleprofil;
	}
	public Collection<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Collection<Personnel> personnels) {
		this.personnels = personnels;
	}
	

}
