package org.avr.metier;

import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.avr.dao.VehiculeRepository;
import org.avr.dao.VisiteTecniqueRepository;
import org.avr.entities.Vehicule;
import org.avr.entities.VisiteTechnique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class VisiteTechniqueMetierImpl implements VisiteTechniqueMetier {
	@Autowired
	private VisiteTecniqueRepository visiteRepository;
	@Autowired
	private VehiculeRepository vehiculeRepository;

	@Override
	public VisiteTechnique saveVisiteTechnique(VisiteTechnique v) {
		v.setEtat(true);
		return visiteRepository.save(v);
	}

	@Override
	public VisiteTechnique updateVisiteTechnique(Long idVisite, VisiteTechnique v) {
		 v.setNumvisite(idVisite);
		 v.setEtat(true);
		return visiteRepository.save(v);
	}

	@Override
	public boolean deleteVisiteTechnique(Long idVisite) {
		if(trouveId(idVisite)==false)
			return false;
		else{
			visiteRepository.deleteVisite(idVisite);
			return true;
		}
	}

	@Override
	public List<VisiteTechnique> getAllVisiteTechnique() {
		// TODO Auto-generated method stub
		return visiteRepository.findAllVisite();
	}

	@Override
	public Page<VisiteTechnique> getVisiteTechniqueParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return visiteRepository.VisiteParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public VisiteTechnique getVisiteTechnique(Long idVisite) {
		// TODO Auto-generated method stub
		return visiteRepository.getVisite(idVisite);
	}

	@Override
	public VisiteTechnique getById(Long idVisite) {
		// TODO Auto-generated method stub
		return visiteRepository.getOne(idVisite);
	}

	@Override
	public List<Vehicule> getVehiculeParDate(LocalDate date) {
		// TODO Auto-generated method stub
		return visiteRepository.getAllVehiculeParDate(date);
	}

	@Override
	public List<Vehicule> getVehiculeIntervaleDate(LocalDate dateJour, LocalDate dateExpiration) {
		// TODO Auto-generated method stub
		return visiteRepository.getAllVehiculeDeuxDate(dateJour, dateExpiration);
	}

	@Override
	public Vehicule addVisiteTechniqueToVehicule(Long idVehicule, Long idVisite) {
		if(trouveId(idVisite)==false||(vehiculeRepository.trouveId(idVehicule)==null)
				||(vehiculeRepository.VehiculeActif(idVehicule)==null))
			return null;
		else{
			Vehicule v=vehiculeRepository.getOne(idVehicule);
			VisiteTechnique vt=visiteRepository.getOne(idVisite);
			v.getVisiteTechniques().add(vt);
			vt.getVehicules().add(v);
			vehiculeRepository.save(v);
			visiteRepository.save(vt);
			return v;
		}
	}

	@Override
	public boolean trouveId(Long idVisite) {
		if(visiteRepository.trouveId(idVisite)==null)
			return false;
		else
			return true;
	}

}
