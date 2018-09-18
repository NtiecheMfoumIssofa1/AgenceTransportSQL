package org.avr.metier;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.avr.entities.Assurance;
import org.avr.entities.Vehicule;
import org.springframework.data.domain.Page;

public interface AssuranceMetier {
	public Assurance saveAssurance(Assurance a);
	public Assurance updateAssurance(Long idAssurance,Assurance a);
	public boolean deleteAssurance(Long idAssurance );
	public List<Assurance> getAllAssurance();
	public Page<Assurance> getAssuranceParMc(String mc, int page,int size);
	public Assurance getAssurence(Long idAssurance );
	public Assurance getById(Long idAssurance );
	public List<Vehicule> getVehiculeParDate(LocalDate date);//liste des véhicule donc le contrat d'assurence expire deja
	public List<Vehicule> getVehiculeIntervaleDate(LocalDate dateJour, LocalDate dateExpiration);//prend la date du jour et la date d'expiration et affiche les assurences entre ces dates
	public Vehicule addAssuranceToVehicule(Long idVehicule, Long idAssurance);
	public boolean trouveId(Long idAssurance);
	
}
