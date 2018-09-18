package org.avr.metier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.avr.entities.Carburant;
import org.avr.entities.Vehicule;
import org.springframework.data.domain.Page;

public interface CarburantMetier {
	public Carburant saveCaburant(Carburant c);
	public Carburant updateCaburant(Long idCarburant, Carburant c);
	public boolean deleteCaburant(Long idCarburant);
	public Carburant getCaburant(Long idCarburant);
	public Page<Carburant> CarburantParMc(String mc, int page, int size);
	public List<Carburant> getAll();
	public List<Vehicule> getCarbuVehiculeParDate(LocalDate date);//liste des vehicule qui ont consommés a cette date
	public List<Vehicule> getAllById(Long idCarburant);//liste des vehicule qui consomment ce carburant
	public boolean trouveId(Long idCarburant);
	public boolean getCarb(Long idCarb);
	public List<Carburant> getCarbParDate(LocalDate date);
	public Double Consommation(Long idCarburant);

}
