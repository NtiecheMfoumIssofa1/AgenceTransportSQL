package org.avr.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.avr.entities.Assurance;
import org.avr.entities.Vehicule;
import org.avr.metier.AssuranceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssuranceRestController {
	@Autowired
	private AssuranceMetier assuranceMetier;
    
	@RequestMapping(value="/Assurance",method=RequestMethod.POST)
	public Assurance saveAssurance( @RequestBody Assurance a) {
		return assuranceMetier.saveAssurance(a);
	}
    @RequestMapping(value="/Assurance/{idAssurance}",method=RequestMethod.PUT)
	public Assurance updateAssurance(@PathVariable Long idAssurance, @RequestBody Assurance a) {
		return assuranceMetier.updateAssurance(idAssurance, a);
	}
    @RequestMapping(value="/Assurance/{idAssurance}",method=RequestMethod.DELETE)
	public boolean deleteAssurance(@PathVariable Long idAssurance) {
		return assuranceMetier.deleteAssurance(idAssurance);
	}
    @RequestMapping(value="/Assurance",method=RequestMethod.GET)
	public List<Assurance> getAllAssurance() {
		return assuranceMetier.getAllAssurance();
	}
    @RequestMapping(value="/AssuranceParMc",method=RequestMethod.GET)
	public Page<Assurance> getAssuranceParMc(
			@RequestParam(name="mc", defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return assuranceMetier.getAssuranceParMc(mc, page, size);
	}
    @RequestMapping(value="/AssuranceId/{idAssurance}",method=RequestMethod.GET)
	public Assurance getAssurence(@PathVariable Long idAssurance) {
		return assuranceMetier.getAssurence(idAssurance);
	}
    @RequestMapping(value="/AssuranceDid/{idAssurance}",method=RequestMethod.GET)
	public Assurance getById(@PathVariable Long idAssurance) {
		return assuranceMetier.getById(idAssurance);
	}
    @RequestMapping(value="/AssuranceDate/{dates}",method=RequestMethod.GET)
	public List<Vehicule> getVehiculeParDate(@PathVariable String dates) throws ParseException {
    	LocalDate date = LocalDate.parse(dates, DateTimeFormatter.ofPattern("uuuu-MM-dd"));//convertion chaine en date 
		return assuranceMetier.getVehiculeParDate(date);
	}
    @RequestMapping(value="/AssuranceDeuxDate/{dateJour}/{dateExpiration}",method=RequestMethod.GET)
	public List<Vehicule> getVehiculeIntervale(@PathVariable String dateJour, @PathVariable String dateExpiration) {
    	LocalDate date1 = LocalDate.parse(dateJour, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
    	LocalDate date2 = LocalDate.parse(dateExpiration, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
		return assuranceMetier.getVehiculeIntervaleDate(date1, date2);
	}
	 @RequestMapping(value="/addAssuranceToVehicule/{idVehicule}/{idAssurance}",method=RequestMethod.POST)
	public Vehicule addAssuranceToVehicule(@PathVariable Long idAssurance,@PathVariable Long idVehicule) {
		return assuranceMetier.addAssuranceToVehicule(idVehicule, idAssurance);
	}

}
