package org.avr.service;

import java.util.List;

import org.avr.entities.Stationnement;
import org.avr.metier.StationnementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationnementRestService {
	@Autowired
	public StationnementMetier stationnementMetier;
	
    @RequestMapping(value="/Stationnement/{idtrajet}", method=RequestMethod.POST)
	public Stationnement saveStationnement(@PathVariable Long idtrajet, @RequestBody Stationnement s) {
		return stationnementMetier.saveStationnement(idtrajet, s);
	}
    @RequestMapping(value="/Stationnement/{idtrajet}/{idStat}", method=RequestMethod.PUT)
	public Stationnement updateStationnement(@PathVariable Long idtrajet, 
											@PathVariable Long idStat, @RequestBody Stationnement s) {
		return stationnementMetier.updateStationnement(idtrajet, idStat, s);
	}
    @RequestMapping(value="/Stationnement/{idStat}", method=RequestMethod.DELETE)
	public boolean deleteStationnement(@PathVariable Long idStat) {
		return stationnementMetier.deleteStationnement(idStat);
	}
    @RequestMapping(value="/Stationnement", method=RequestMethod.GET)
	public List<Stationnement> getAllStationnement() {
		return stationnementMetier.getAllStationnement();
	}
    @RequestMapping(value="/StationnementParMc", method=RequestMethod.GET)
	public Page<Stationnement> chercherStat(
			@RequestParam(name="mc", defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return stationnementMetier.chercherStat(mc, page, size);
	}
    @RequestMapping(value="/StationnementParTrajet/{idTrajet}", method=RequestMethod.GET)
	public List<Stationnement> StationnementParTrajet(@PathVariable Long idTrajet) {
		return stationnementMetier.StationnementParTrajet(idTrajet);
	}

}
