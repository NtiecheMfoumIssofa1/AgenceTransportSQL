package org.avr.service;

import java.util.List;

import org.avr.entities.GareRoutiere;
import org.avr.entities.Ville;
import org.avr.metier.GareRoutiereMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GareRoutiereRestService {
	@Autowired
	private GareRoutiereMetier gareRoutiereMetier; 
    
	@RequestMapping(value="/Gare/{idVille}", method=RequestMethod.POST)
	public GareRoutiere saveGare(@PathVariable Long idVille,@RequestBody GareRoutiere g) {
		return gareRoutiereMetier.saveGare(idVille, g);
	}
	@RequestMapping(value="/Gare/{idVille}/{idGare}", method=RequestMethod.PUT)
	public GareRoutiere updateGare(@PathVariable Long idVille, @PathVariable Long idGare, @RequestBody GareRoutiere g) {
		return gareRoutiereMetier.updateGare(idVille, idGare, g);
	}
	@RequestMapping(value="/Gare/{idGare}", method=RequestMethod.DELETE)
	public boolean deleteGare(@PathVariable Long idGare) {
		return gareRoutiereMetier.deleteGare(idGare);
	}
	@RequestMapping(value="/Gare", method=RequestMethod.GET)
	public List<GareRoutiere> getAllGare() {
		return gareRoutiereMetier.getAllGare();
	}
	@RequestMapping(value="/GareParMc", method=RequestMethod.GET)
	public Page<GareRoutiere> GareRoutierParMc(
								@RequestParam(name="mc", defaultValue="")String mc, 
								@RequestParam(name="page", defaultValue="0")int page, 
								@RequestParam(name="size", defaultValue="5")int size) {
		return gareRoutiereMetier.GareRoutierParMc(mc, page, size);
	}
	@RequestMapping(value="/GareId/{idGare}", method=RequestMethod.GET)
	public GareRoutiere getById(@PathVariable Long idGare) {
		return gareRoutiereMetier.getById(idGare);
	}

}
