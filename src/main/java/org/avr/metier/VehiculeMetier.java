package org.avr.metier;

import java.time.LocalDate;
import java.util.List;

import org.avr.entities.Assurance;
import org.avr.entities.Vehicule;
import org.springframework.data.domain.Page;

public interface VehiculeMetier {
	public Vehicule saveVehicule(Long idType,Vehicule v);
	public Vehicule updateVehicule(Long idtype, Long id, Vehicule v);
	public boolean deleteVehicule(Long id);
	public Page<Vehicule> VehiculeParMc(String mc, int page,int size);
	public List<Vehicule> getAllVehicule();
	public Long trouveId(Long id);
	public Vehicule getVehicule(Long idVehicule);
	public Vehicule addVehiculeToTrajet(Long idTrajet, Long idVehicule);
	public boolean activevehicule(Long idVehicule);
	public boolean activeTrajet(Long idTrajet);
	public void activeVehiculeActif(Long idVehicule);
	public void desactiveVehiculeActif(Long idVehicule); 
	public List<Assurance> getAssurenceParVehicule(Long idVehicule);//liste des vehicules par assurances

}
