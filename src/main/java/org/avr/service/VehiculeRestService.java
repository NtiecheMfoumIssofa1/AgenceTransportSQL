package org.avr.service;

import java.util.List;

import org.avr.entities.Assurance;
import org.avr.entities.Vehicule;
import org.avr.metier.VehiculeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculeRestService {
	@Autowired
	private VehiculeMetier vehiculeMetier;

	@RequestMapping(value="/Vehicule/{idType}",method=RequestMethod.POST)
	public Vehicule saveVehicule(@PathVariable Long idType,@RequestBody Vehicule v) {
		return vehiculeMetier.saveVehicule(idType,v);
	}
	@RequestMapping(value="/Vehicule/{idType}/{id}",method=RequestMethod.PUT)
	public Vehicule updateVehicule(@PathVariable Long idType,@PathVariable Long id, @RequestBody Vehicule v) {
		return vehiculeMetier.updateVehicule(idType,id, v);
	}
	@RequestMapping(value="/Vehicule/{id}",method=RequestMethod.DELETE)
	public boolean deleteVehicule(@PathVariable Long id) {
		return vehiculeMetier.deleteVehicule(id);
	}
	@RequestMapping(value="/VehiculeParMc",method=RequestMethod.GET)
	public Page<Vehicule> VehiculeParMc(
			@RequestParam (name="mc",defaultValue="")String mc, 
			@RequestParam (name="page",defaultValue="0")int page, 
			@RequestParam (name="size", defaultValue="5")int size) {
		return vehiculeMetier.VehiculeParMc(mc, page, size);
	}
	@RequestMapping(value="/Vehicule",method=RequestMethod.GET)
	public List<Vehicule> getAllVehicule() {
		return vehiculeMetier.getAllVehicule();
	}
	@RequestMapping(value="/VehiculeId/{idVehicule}",method=RequestMethod.GET)
	public Vehicule getVehicule(@PathVariable Long idVehicule) {
		return vehiculeMetier.getVehicule(idVehicule);
	}
	
	@RequestMapping(value="/VehiculeActive/{idVehicule}",method=RequestMethod.PUT)
	public void activeVehiculeActif(@PathVariable Long idVehicule) {
		vehiculeMetier.activeVehiculeActif(idVehicule);
	}
	@RequestMapping(value="/VehiculeDesactive/{idVehicule}",method=RequestMethod.PUT)
	public void desactiveVehiculeActif(@PathVariable Long idVehicule) { 
		vehiculeMetier.desactiveVehiculeActif(idVehicule);
	}
	@RequestMapping(value="/VehiculeAssurence/{idVehicule}",method=RequestMethod.GET)
	public List<Assurance> getAssurenceParVehicule(@PathVariable Long idVehicule) {
		return vehiculeMetier.getAssurenceParVehicule(idVehicule);
	}
	@RequestMapping(value="/addVehiculeToTrajet/{idTrajet}/{idVehicule}",method=RequestMethod.POST)
	public Vehicule addVehiculeToTrajet(@PathVariable Long idTrajet, @PathVariable Long idVehicule) {
		return vehiculeMetier.addVehiculeToTrajet(idTrajet, idVehicule);
	}

}
