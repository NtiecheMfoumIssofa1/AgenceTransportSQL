package org.avr.metier;

import java.time.LocalDate;
import java.util.List;

import org.avr.entities.Vehicule;
import org.avr.entities.VisiteTechnique;
import org.springframework.data.domain.Page;

public interface VisiteTechniqueMetier {
	public VisiteTechnique saveVisiteTechnique(VisiteTechnique v);
	public VisiteTechnique updateVisiteTechnique(Long idVisite,VisiteTechnique v);
	public boolean deleteVisiteTechnique(Long idVisite );
	public List<VisiteTechnique> getAllVisiteTechnique();
	public Page<VisiteTechnique> getVisiteTechniqueParMc(String mc, int page,int size);
	public VisiteTechnique getVisiteTechnique(Long idVisite );
	public VisiteTechnique getById(Long idVisite );
	public List<Vehicule> getVehiculeParDate(LocalDate date);//liste des véhicule donc le contrat d'assurence expire deja
	public List<Vehicule> getVehiculeIntervaleDate(LocalDate dateJour, LocalDate dateExpiration);//prend la date du jour et la date d'expiration et affiche les assurences entre ces dates
	public Vehicule addVisiteTechniqueToVehicule(Long idVehicule, Long idVisite);
	public boolean trouveId(Long idVisite);

}
