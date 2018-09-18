package org.avr.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.avr.entities.Taxe;
import org.avr.entities.Vehicule;
import org.avr.metier.TaxeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxeRestService {
	@Autowired
	private TaxeMetier taxeMetier;

	@RequestMapping(value="/Taxe",method=RequestMethod.POST)
	public Taxe saveTaxe(@RequestBody Taxe t) {
		return taxeMetier.saveTaxe(t);
	}
	@RequestMapping(value="/Taxe/{idTaxe}",method=RequestMethod.PUT)
	public Taxe updateVisiteTechnique(@PathVariable Long idTaxe, @RequestBody Taxe t) {
		return taxeMetier.updateVisiteTechnique(idTaxe, t);
	}
	@RequestMapping(value="/Taxe/{idTaxe}",method=RequestMethod.DELETE)
	public boolean deleteTaxe(@PathVariable Long idTaxe) {
		return taxeMetier.deleteTaxe(idTaxe);
	}
	@RequestMapping(value="/Taxe",method=RequestMethod.GET)
	public List<Taxe> getAllTaxe() {
		return taxeMetier.getAllTaxe();
	}
	@RequestMapping(value="/TaxeParMc",method=RequestMethod.GET)
	public Page<Taxe> getTaxeParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return taxeMetier.getTaxeParMc(mc, page, size);
	}
	@RequestMapping(value="/TaxeActive/{idtaxe}",method=RequestMethod.GET)
	public Taxe getTaxe(@PathVariable Long idtaxe) {
		return taxeMetier.getTaxe(idtaxe);
	}
	@RequestMapping(value="/TaxeId/{idtaxe}",method=RequestMethod.GET)
	public Taxe getById(@PathVariable Long idtaxe) {
		return taxeMetier.getById(idtaxe);
	}
	@RequestMapping(value="/TaxeParDate/{date}",method=RequestMethod.GET)
	public List<Vehicule> getVehiculeParDate(@PathVariable String date) {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return taxeMetier.getVehiculeParDate(dates);
	}
	@RequestMapping(value="/TaxeEntreDate/{dateCirculation}/{expirationtaxe}",method=RequestMethod.GET)
	public List<Vehicule> getVehiculeIntervaleDate(@PathVariable String dateCirculation, 
													@PathVariable String expirationtaxe) {
		LocalDate date1=LocalDate.parse(dateCirculation, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate date2=LocalDate.parse(expirationtaxe, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return taxeMetier.getVehiculeIntervaleDate(date1, date2);
	}
	@RequestMapping(value="/addTaxeToVehicule/{idVehicule}/{idTaxe}",method=RequestMethod.GET)
	public Vehicule addTaxeToVehicule(@PathVariable Long idVehicule, @PathVariable Long idTaxe) {
		return taxeMetier.addTaxeToVehicule(idVehicule, idTaxe);
	}

}
