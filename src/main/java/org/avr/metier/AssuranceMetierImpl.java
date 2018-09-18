package org.avr.metier;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.avr.dao.AssuranceRepository;
import org.avr.dao.VehiculeRepository;
import org.avr.entities.Assurance;
import org.avr.entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class AssuranceMetierImpl implements AssuranceMetier{
  @Autowired
  private AssuranceRepository assuranceRepository;
  @Autowired
  private VehiculeRepository vehiculeRepository;
	@Override
	public Assurance saveAssurance(Assurance a) {
		a.setEtat(true);
		return assuranceRepository.save(a);
	}

	@Override
	public Assurance updateAssurance(Long idAssurance, Assurance a) {
		a.setNumAssurance(idAssurance);
		a.setEtat(true);
		return assuranceRepository.save(a);
	}

	@Override
	public boolean deleteAssurance(Long idAssurance) {
		assuranceRepository.deleteAssurance(idAssurance);
		return true;
	}

	@Override
	public List<Assurance> getAllAssurance() {
		// TODO Auto-generated method stub
		return assuranceRepository.findAllAssurance();
	}

	@Override
	public Page<Assurance> getAssuranceParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return assuranceRepository.AssurenceParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Assurance getAssurence(Long idAssurance) {
		// TODO Auto-generated method stub
		return assuranceRepository.getAssurance(idAssurance);
	}

	@Override
	public Assurance getById(Long idAssurance) {
		// TODO Auto-generated method stub
		return assuranceRepository.getOne(idAssurance);
	}

	@Override
	public List<Vehicule> getVehiculeParDate(LocalDate date) {
		// TODO Auto-generated method stub
		return assuranceRepository.getAllVehiculeParDate(date);
	}

	@Override
	public List<Vehicule> getVehiculeIntervaleDate(LocalDate dateJour, LocalDate dateExpiration) {
		// TODO Auto-generated method stub
		return assuranceRepository.getAllVehiculeDeuxDate(dateJour, dateExpiration);
	}

	@Override
	public Vehicule addAssuranceToVehicule(Long idVehicule , Long idAssurance ) {
		if((vehiculeRepository.trouveId(idVehicule)==null)||(trouveId(idAssurance)==false)){
			return null; 
		}else if(vehiculeRepository.VehiculeActif(idVehicule)==null){
			return null;
		}else{
			Vehicule v =vehiculeRepository.getOne(idVehicule);
			Assurance a = assuranceRepository.getOne(idAssurance); 
			v.getAssurances().add(a);
			a.getVehicules().add(v);
			vehiculeRepository.save(v);
			assuranceRepository.save(a);
			return v;
		}
		
			
		}
	

	@Override
	public boolean trouveId(Long idAssurance) {
		if(assuranceRepository.trouveId(idAssurance)==null)
				return false;
		else
			return true;
	}

	

}
