package org.avr.service;

import java.util.List;

import org.avr.entities.GareRoutiere;
import org.avr.entities.Trajet;
import org.avr.metier.TrajetMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrajetRestService {
	@Autowired
	public TrajetMetier trajetMetier;

	@RequestMapping(value="/Trajet", method=RequestMethod.POST)
	public Trajet saveTrajet(@RequestBody Trajet t) {
		return trajetMetier.saveTrajet(t);
	}
	@RequestMapping(value="/Trajet/{idTrajet}", method=RequestMethod.PUT)
	public Trajet updateTrajet(@PathVariable Long idTrajet, @RequestBody Trajet t) {
		return trajetMetier.updateTrajet(idTrajet, t);
	}
	@RequestMapping(value="/Trajet/{idTrajet}", method=RequestMethod.DELETE)
	public boolean deleteTrajet(@PathVariable Long idTrajet) {
		return trajetMetier.deleteTrajet(idTrajet);
	}
	@RequestMapping(value="/TrajetId/{idTrajet}", method=RequestMethod.GET)
	public Trajet getById(@PathVariable Long idTrajet) {
		return trajetMetier.getById(idTrajet);
	}
	@RequestMapping(value="/Trajet", method=RequestMethod.GET)
	public List<Trajet> getAllTrajet() {
		return trajetMetier.getAllTrajet();
	}
	@RequestMapping(value="/TrajetParMc", method=RequestMethod.GET)
	public Page<Trajet> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return trajetMetier.getParMc(mc, page, size);
	}
	@RequestMapping(value="/addTrajetToGare/{idGare}/{idTrajet}", method=RequestMethod.POST)
	public Trajet addTrajetToGare(@PathVariable Long idGare, @PathVariable Long idTrajet) {
		return trajetMetier.addTrajetToGare(idGare, idTrajet);
	}
	@RequestMapping(value="/TrajetParGare/{idGare}", method=RequestMethod.GET)
	public List<Trajet> TrajetParGare(@PathVariable Long idGare) {
		return trajetMetier.TrajetParGare(idGare);
	}

}
