package org.avr.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.avr.dao.CarburantRepository;
import org.avr.entities.Carburant;
import org.avr.entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class CarburantMetierImpl implements CarburantMetier{
	@Autowired
  private CarburantRepository carburantRepository;
	@Override
	public Carburant saveCaburant(Carburant c) {
		c.setEtat(true); 
		// LocalDate date = LocalDate.parse(c.getDateCarb().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		 //c.setDateCarb(date);
		return carburantRepository.save(c);
	}

	@Override
	public Carburant updateCaburant(Long idCarburant, Carburant c) {
		if(trouveId(idCarburant)==false)
		return c;
		else{
			c.setEtat(true);
			c.setIdCarb(idCarburant);
			return carburantRepository.save(c);
		}
	}

	@Override
	public boolean deleteCaburant(Long idCarburant) {
		if(trouveId(idCarburant)==false)
			return false;
			else{
				carburantRepository.deleteCarburant(idCarburant);
				return true;
			}
	}

	@Override
	public Carburant getCaburant(Long idCarburant) {
		Carburant c =carburantRepository.getOne(idCarburant);
		return c;
	}

	@Override
	public Page<Carburant> CarburantParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return carburantRepository.CarburantParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public List<Carburant> getAll() {
		// TODO Auto-generated method stub
		return carburantRepository.findAllCarburant();
	}

	
	public List<Vehicule> getCarbuVehiculeParDate(LocalDate dateConsommation) {
		// TODO Auto-generated method stub
		return carburantRepository.getCarbuVehiculeParDate(dateConsommation);
	}

	@Override
	public List<Vehicule> getAllById(Long idCarburant) {
		// TODO Auto-generated method stub
		return carburantRepository.getVehicule(idCarburant);
	}

	@Override
	public boolean trouveId(Long idCarburant) {
		if(carburantRepository.trouveId(idCarburant)==null)
			return false;
		else
			return true;
	}

	@Override
	public boolean getCarb(Long idCarb) {
		if(carburantRepository.carburantActive(idCarb)==null)
			return false;
		else
			return true;
	}

	@Override
	public List<Carburant> getCarbParDate(LocalDate date) {
		// TODO Auto-generated method stub
		return carburantRepository.getCarbParDate(date);
	}

	@Override
	public Double Consommation(Long idCarburant) {
		if((trouveId(idCarburant)==false) ||(getCarb(idCarburant)==false))
	    return null;
		else{
			Carburant c =carburantRepository.getOne(idCarburant);
			double s=c.getQuantiteCarb()*c.getCoutCarb();
			return s;
		}
		
	}

}
