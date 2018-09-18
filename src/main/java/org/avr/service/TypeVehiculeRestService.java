package org.avr.service;

import java.util.List;

import org.avr.entities.TypeVehicule;
import org.avr.entities.Vehicule;
import org.avr.metier.TypeVehiculeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeVehiculeRestService {
	@Autowired
	private TypeVehiculeMetier typeVehiculeMetier;
	@RequestMapping(value="/TypeVehicule", method=RequestMethod.POST)
	public TypeVehicule saveTypeV(@RequestBody TypeVehicule t) {
		return typeVehiculeMetier.saveTypeV(t);
	}
	@RequestMapping(value="/TypeVehicule/{idType}", method=RequestMethod.PUT)
	public TypeVehicule updateTypeV(@PathVariable Long idType, @RequestBody TypeVehicule t) {
		return typeVehiculeMetier.updateTypeV(idType, t);
	}
	@RequestMapping(value="/TypeVehicule/{idType}", method=RequestMethod.DELETE)
	public boolean deleteTypeV(@PathVariable Long idType) {
		return typeVehiculeMetier.deleteTypeV(idType);
	}
	@RequestMapping(value="/TypeVehiculeParMc", method=RequestMethod.GET)
	public Page<TypeVehicule> TypeVehiculeParMc(
			 @RequestParam(name="mc",defaultValue="")String mc, 
			 @RequestParam(name="page", defaultValue="0")int page, 
			 @RequestParam(name="size",defaultValue="5")int size) {
		return typeVehiculeMetier.TypeVehiculeParMc(mc, page, size);
	}
	@RequestMapping(value="/TypeVehicule", method=RequestMethod.GET)
	public List<TypeVehicule> getAllTypeV() {
		return typeVehiculeMetier.getAllTypeV();
	}
	@RequestMapping(value="/TypeVehiculeId/{idType}", method=RequestMethod.GET)
	public TypeVehicule getById(@PathVariable Long idType) {
		return typeVehiculeMetier.getById(idType);
	}
	@RequestMapping(value="/VehiculeParType/{id}", method=RequestMethod.GET)
	public Page<Vehicule> getVehiculeParType(@PathVariable Long id, 
						@RequestParam(name="page",defaultValue="0")int page, 
						@RequestParam(name="size",defaultValue="5")int size) {
		return typeVehiculeMetier.getVehiculeParType(id, page, size);
	}
	

}
