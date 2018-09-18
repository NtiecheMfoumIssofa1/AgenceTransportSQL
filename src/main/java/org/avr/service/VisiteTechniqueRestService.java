package org.avr.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.avr.entities.Vehicule;
import org.avr.entities.VisiteTechnique;
import org.avr.metier.VisiteTechniqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisiteTechniqueRestService {
	@Autowired
	private VisiteTechniqueMetier visiteTechniqueMetier;
	
	@RequestMapping(value="/Visite",method=RequestMethod.POST)
	public VisiteTechnique saveVisiteTechnique(@RequestBody VisiteTechnique v) {
		return visiteTechniqueMetier.saveVisiteTechnique(v);
	}
	@RequestMapping(value="/Visite/{idVisite}",method=RequestMethod.PUT)
	public VisiteTechnique updateVisiteTechnique(@PathVariable Long idVisite, 
				@RequestBody VisiteTechnique v) {
		return visiteTechniqueMetier.updateVisiteTechnique(idVisite, v);
	}
	@RequestMapping(value="/Visite/{idVisite}",method=RequestMethod.DELETE)
	public boolean deleteVisiteTechnique(@PathVariable Long idVisite) {
		return visiteTechniqueMetier.deleteVisiteTechnique(idVisite);
	}
	@RequestMapping(value="/Visite",method=RequestMethod.GET)
	public List<VisiteTechnique> getAllVisiteTechnique() {
		return visiteTechniqueMetier.getAllVisiteTechnique();
	}
	@RequestMapping(value="/VisiteParMc",method=RequestMethod.GET)
	public Page<VisiteTechnique> getVisiteTechniqueParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return visiteTechniqueMetier.getVisiteTechniqueParMc(mc, page, size);
	}
	@RequestMapping(value="/VisiteActive/{idVisite}",method=RequestMethod.GET)
	public VisiteTechnique getVisiteTechnique(@PathVariable Long idVisite) {
		return visiteTechniqueMetier.getVisiteTechnique(idVisite);
	}
	@RequestMapping(value="/VisiteId/{idVisite}",method=RequestMethod.GET)
	public VisiteTechnique getById(@PathVariable Long idVisite) {
		return visiteTechniqueMetier.getById(idVisite);
	}
	@RequestMapping(value="/VisiteParDate/{date}",method=RequestMethod.GET)
	public List<Vehicule> getVehiculeParDate(@PathVariable String date) {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
		return visiteTechniqueMetier.getVehiculeParDate(dates);
	}
	@RequestMapping(value="/VisiteIntervaleDate/{dateJour}/{dateExpiration}",method=RequestMethod.GET)
	public List<Vehicule> getVehiculeIntervaleDate(@PathVariable String dateJour,@PathVariable String dateExpiration) {
		LocalDate date1=LocalDate.parse(dateJour, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
		LocalDate date2=LocalDate.parse(dateExpiration, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
		return visiteTechniqueMetier.getVehiculeIntervaleDate(date1, date2);
	}
	@RequestMapping(value="/addVisiteTechniqueToVehicule/{idVehicule}/{idVisite}",method=RequestMethod.POST)
	public Vehicule addVisiteTechniqueToVehicule(@PathVariable Long idVehicule,@PathVariable Long idVisite) {
		return visiteTechniqueMetier.addVisiteTechniqueToVehicule(idVehicule, idVisite);
	}

}
