package org.avr.service;

import java.util.List;

import org.avr.entities.Region;
import org.avr.entities.Ville;
import org.avr.metier.RegionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionRestService { 
	@Autowired
	private RegionMetier regionMetier; 
	
	@RequestMapping(value="/Region/{idPays}",method=RequestMethod.POST)
	public Region saveRegion(@PathVariable Long idPays, @RequestBody Region r) {
		return regionMetier.saveRegion(idPays, r);
	}
	
	@RequestMapping(value="/Region/{idPays}/{idRegion}",method=RequestMethod.PUT)
	public Region updateRegion(@PathVariable Long idPays, 
								@PathVariable Long idRegion, 
							   @RequestBody Region r) {
		return regionMetier.updateRegion(idPays, idRegion, r);
	}
	
	@RequestMapping(value="/Region/{idRegion}",method=RequestMethod.DELETE)
	public boolean deleteRegion(@PathVariable Long idRegion) {
		return regionMetier.deleteRegion(idRegion);
	}
	
	@RequestMapping(value="/Region",method=RequestMethod.GET)
	public List<Region> getAllRegion() {
		return regionMetier.getAllRegion();
	}
	
	@RequestMapping(value="/RegionParMC",method=RequestMethod.GET)
	public Page<Region> RegionParMC(
			@RequestParam(name="mc", defaultValue="")String mc, 
			@RequestParam (name="page", defaultValue="0")int page, 
			@RequestParam(name="size", defaultValue="5")int size) {
		return regionMetier.RegionParMC(mc, page, size);
	}
	
	@RequestMapping(value="/RegionId/{id}",method=RequestMethod.GET)
	public Region getRegion(@PathVariable Long id) {
		return regionMetier.getRegion(id);
	}
	@RequestMapping(value="/VilleParRegion/{idRegion}",method=RequestMethod.GET)
	public List<Ville> VilleParRegion(@PathVariable Long idRegion) {
		return regionMetier.VilleParRegion(idRegion);
	}

}
