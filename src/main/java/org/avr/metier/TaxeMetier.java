package org.avr.metier;

import java.time.LocalDate;
import java.util.List;

import org.avr.entities.Taxe;
import org.avr.entities.Vehicule;
import org.springframework.data.domain.Page;

public interface TaxeMetier {
	public Taxe saveTaxe(Taxe t);
	public Taxe updateVisiteTechnique(Long idTaxe,Taxe t);
	public boolean deleteTaxe(Long idTaxe );
	public List<Taxe> getAllTaxe();
	public Page<Taxe> getTaxeParMc(String mc, int page,int size);
	public Taxe getTaxe(Long idtaxe );
	public Taxe getById(Long idtaxe );
	public List<Vehicule> getVehiculeParDate(LocalDate date);//liste des véhicule donc le contrat d'assurence expire deja
	public List<Vehicule> getVehiculeIntervaleDate(LocalDate dateCirculation, LocalDate expirationtaxe);//prend la date du jour et la date d'expiration et affiche les assurences entre ces dates
	public Vehicule addTaxeToVehicule(Long idVehicule, Long idTaxe);
	public boolean trouveId(Long idTaxe);

}
