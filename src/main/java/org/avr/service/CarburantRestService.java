package org.avr.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.avr.entities.Carburant;
import org.avr.entities.Vehicule;
import org.avr.metier.CarburantMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarburantRestService {
	@Autowired
	private CarburantMetier carburantMetier;

@RequestMapping(value="/Carburant",method=RequestMethod.POST)
	public Carburant saveCaburant(@RequestBody Carburant c) {
		return carburantMetier.saveCaburant(c);
	}
  @RequestMapping(value="/Carburant/{idCarburant}",method=RequestMethod.PUT)
	public Carburant updateCaburant(@PathVariable Long idCarburant, @RequestBody Carburant c) {
		return carburantMetier.updateCaburant(idCarburant, c);
	}
  @RequestMapping(value="/Carburant/{idCarburant}",method=RequestMethod.DELETE)
	public boolean deleteCaburant(@PathVariable Long idCarburant) {
		return carburantMetier.deleteCaburant(idCarburant);
	}
  @RequestMapping(value="/CarburantId/{idCarburant}",method=RequestMethod.GET)
	public Carburant getCaburant(@PathVariable Long idCarburant) {
		return carburantMetier.getCaburant(idCarburant);
	}
  @RequestMapping(value="/CarburantParMc",method=RequestMethod.GET)
	public Page<Carburant> CarburantParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam (name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return carburantMetier.CarburantParMc(mc, page, size);
	}
  @RequestMapping(value="/Carburant",method=RequestMethod.GET)
	public List<Carburant> getAll() {
		return carburantMetier.getAll();
	}
  @RequestMapping(value="/CarburantVehiculeParDate/{dateConsommation}",method=RequestMethod.GET)
	public List<Vehicule> getAllParDate( @PathVariable String dateConsommation) throws ParseException {
	  	LocalDate date = LocalDate.parse(dateConsommation, DateTimeFormatter.ofPattern("uuuu-MM-dd"));//convertion chaine en date
		return carburantMetier.getCarbuVehiculeParDate(date);
	}
  @RequestMapping(value="/CarburantVehicule/{idCarburant}",method=RequestMethod.GET)
	public List<Vehicule> getAllById(@PathVariable Long idCarburant) {
		return carburantMetier.getAllById(idCarburant);
	}
  @RequestMapping(value="/CarburantParDate/{date}",method=RequestMethod.GET)
	public List<Carburant> getCarbParDate(@PathVariable String date) {
	  LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return carburantMetier.getCarbParDate(dates);
	}
  @RequestMapping(value="/CarburantConsommation/{idCarburant}",method=RequestMethod.GET)
  public Double Consommation(@PathVariable Long idCarburant) {
	return carburantMetier.Consommation(idCarburant);
}

}
