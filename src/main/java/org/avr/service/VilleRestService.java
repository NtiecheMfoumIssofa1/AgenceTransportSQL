package org.avr.service;

import java.util.List;

import org.avr.entities.Carburant;
import org.avr.entities.GareRoutiere;
import org.avr.entities.Ville;
import org.avr.metier.VilleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VilleRestService {
	@Autowired
	private VilleMetier villeMetier; 

	@RequestMapping(value="/Ville/{idRegion}", method=RequestMethod.POST)
	public Ville saveVille(@PathVariable Long idRegion, @RequestBody Ville v) {
		return villeMetier.saveVille(idRegion, v);
	}
    
	@RequestMapping(value="/Ville/{idregion}/{idVille}", method=RequestMethod.PUT)
	public Ville updateVille(@PathVariable Long idregion, @PathVariable Long idVille,
								@RequestBody Ville v) {
		return villeMetier.updateVille(idregion, idVille, v);
	}

	@RequestMapping(value="/Ville/{idville}", method=RequestMethod.DELETE)
	public boolean deleteVille(@PathVariable Long idville) {
		return villeMetier.deleteVille(idville);
	}
	@RequestMapping(value="/Ville", method=RequestMethod.GET)
	public List<Ville> getAllVille() {
		return villeMetier.getAllVille();
	}
	@RequestMapping(value="/VilleParMc", method=RequestMethod.GET)
	public Page<Ville> VilleParMc(
								@RequestParam(name="mc", defaultValue="")String mc, 
								@RequestParam(name="page", defaultValue="0")int page, 
								@RequestParam(name="size", defaultValue="5")int size) {
		return villeMetier.VilleParMc(mc, page, size);
	}
	@RequestMapping(value="/VilleId/{idVille}", method=RequestMethod.GET)
	public Ville getById(@PathVariable Long idVille) {
		return villeMetier.getById(idVille);
	}
	@RequestMapping(value="/GareParVille/{idVille}", method=RequestMethod.GET)
	public List<GareRoutiere> GareParVille(@PathVariable Long idVille) {
		return villeMetier.GareParVille(idVille);
	}
	@RequestMapping(value="/CaburantParVille/{idVille}", method=RequestMethod.GET)
	public List<Carburant> getCaburantParVille(@PathVariable Long idVille) {
		return villeMetier.getCaburantParVille(idVille);
	}
	@RequestMapping(value="/addCarburantToVille/{idVille}/{idCarb}", method=RequestMethod.POST)
	public Ville addCarburantToVille(@PathVariable Long idVille, @PathVariable Long idCarb) {
		return villeMetier.addCarburantToVille(idVille, idCarb);
	}

}
