package org.avr.metier;

import java.time.LocalDate;
import java.util.List;

import org.avr.dao.TaxeRepository;
import org.avr.dao.VehiculeRepository;
import org.avr.entities.Taxe;
import org.avr.entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class TaxeMetierImpl implements TaxeMetier{
	@Autowired
	private TaxeRepository taxeRepository;
	@Autowired
	private VehiculeRepository vehiculeRepository;
	@Override
	public Taxe saveTaxe(Taxe t) {
		t.setEtat(true);
		return taxeRepository.save(t);
	}

	@Override
	public Taxe updateVisiteTechnique(Long idTaxe, Taxe t) {
		if(trouveId(idTaxe)==false)
			return t;
		else{
			t.setNumTaxe(idTaxe);
			t.setEtat(true);
			return taxeRepository.save(t);
		}
	}

	@Override
	public boolean deleteTaxe(Long idTaxe) {
		if(trouveId(idTaxe)==false)
			return false;
		else{
			taxeRepository.deleteTaxe(idTaxe);
			return true;
		}
	}

	@Override
	public List<Taxe> getAllTaxe() {
		// TODO Auto-generated method stub
		return taxeRepository.findAllTaxe();
	}

	@Override
	public Page<Taxe> getTaxeParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return taxeRepository.TaxeParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Taxe getTaxe(Long idtaxe) {
		// TODO Auto-generated method stub
		return taxeRepository.getTaxe(idtaxe);
	}

	@Override
	public Taxe getById(Long idtaxe) {
		// TODO Auto-generated method stub
		return taxeRepository.getOne(idtaxe);
	}

	@Override
	public List<Vehicule> getVehiculeParDate(LocalDate date) {
		// TODO Auto-generated method stub
		return taxeRepository.getAllVehiculeParDate(date);
	}

	@Override
	public List<Vehicule> getVehiculeIntervaleDate(LocalDate dateCirculation, LocalDate expirationtaxe) {
		// TODO Auto-generated method stub
		return taxeRepository.getAllVehiculeDeuxDate(dateCirculation, expirationtaxe);
	}

	@Override
	public Vehicule addTaxeToVehicule(Long idVehicule, Long idTaxe) {
		if((trouveId(idTaxe)==false)||(vehiculeRepository.trouveId(idVehicule)==null)
				||(vehiculeRepository.VehiculeActif(idVehicule)==null))
			return null;
		else{
			Vehicule v=vehiculeRepository.getOne(idVehicule);
			Taxe t=taxeRepository.getOne(idTaxe);
			v.getTaxes().add(t);
			t.getVehicules().add(v);
			vehiculeRepository.save(v);
			taxeRepository.save(t);
			return v;
		}
	}

	@Override
	public boolean trouveId(Long idTaxe) {
		if(taxeRepository.trouveId(idTaxe)==null)
			return false;
		else return true;
	}

}
