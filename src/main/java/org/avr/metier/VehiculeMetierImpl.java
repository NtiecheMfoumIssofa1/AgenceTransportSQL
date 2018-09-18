package org.avr.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.avr.dao.TrajetRepository;
import org.avr.dao.VehiculeRepository;
import org.avr.dao.VehiculeTypeRepository;
import org.avr.entities.Assurance;
import org.avr.entities.Trajet;
import org.avr.entities.TypeVehicule;
import org.avr.entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class VehiculeMetierImpl implements VehiculeMetier{
	@Autowired
	private VehiculeRepository vehiculeRepository;
	@Autowired
	private VehiculeTypeRepository typeVehicule;
	@Autowired
	private TrajetRepository trajetRepository;

	@Override
	public Vehicule saveVehicule(Long idType,Vehicule v) {
		TypeVehicule t = typeVehicule.getOne(idType);
		v.setTypeVehicule(t);
		v.setActif(true);//vehicule peut effectuer un voyage
		v.setEtat(true);//vehicule existe
		return vehiculeRepository.save(v);
	}

	@Override
	public Vehicule updateVehicule(Long idType,Long id, Vehicule v) {
		if((id==null)||(idType==null)){
			return v;
		}
		else if(trouveId(id)==null){
			return v;
		}else{
			TypeVehicule t = typeVehicule.getOne(idType);
			v.setTypeVehicule(t);
			v.setIdVehicule(id);
			v.setEtat(true);
			v.setActif(true);
			return  vehiculeRepository.save(v);
		}
		
	}

	@Override
	public boolean deleteVehicule(Long id) {
		if(id==null){
			return false;
		}
		else if(trouveId(id)==null){
			return false;
		}else{
			 vehiculeRepository.deleteVehicule(id);
			return true;
		}
		
	}

	@Override
	public Page<Vehicule> VehiculeParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return vehiculeRepository.VehiculeParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public List<Vehicule> getAllVehicule() {
		// TODO Auto-generated method stub
		return vehiculeRepository.findAllVehicule();
	}

	@Override
	public Long trouveId(Long id) {
		// TODO Auto-generated method stub
		return vehiculeRepository.trouveId(id);
	}

	@Override
	public Vehicule getVehicule(Long idVehicule) {
		Vehicule v = vehiculeRepository.getOne(idVehicule);
		return v;
	}

	@Override
	public Vehicule addVehiculeToTrajet(Long idTrajet, Long idVehicule) {
		Trajet t= trajetRepository.getOne(idTrajet);
		Vehicule v=vehiculeRepository.getOne(idVehicule);
	      if((activevehicule(idVehicule)==false) || (activeTrajet(idTrajet)==false)){
	    	  return v;
	      }else{
	    	  v.getTrajets().add(t);
				t.getVehicules().add(v);
				trajetRepository.save(t);
				vehiculeRepository.save(v);
				return v;
	      }
				

		}

	@Override
	public boolean activevehicule(Long idVehicule) {
		if(vehiculeRepository.activeVehiculeEtat(idVehicule)!=null){
		   if(vehiculeRepository.VehiculeActif(idVehicule)!=null){
			return true;
		  }
		   
		}
		return false;
		
	}
	

	@Override
	public boolean activeTrajet(Long idTrajet) {
		if(trajetRepository.activeTrajet(idTrajet)==null)
		return false;
		else
			return true;
	}

	@Override
	public void activeVehiculeActif(Long idVehicule) {
		 
		 vehiculeRepository.activeVehicule(idVehicule);
	}

	@Override
	public void desactiveVehiculeActif(Long idVehicule) {
		vehiculeRepository.desactiveVehicule(idVehicule);
		
	}

	@Override
	public List<Assurance> getAssurenceParVehicule(Long idVehicule) {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public List<Assurance> getAssurenceParVehicule(Long idVehicule) {
		List<Assurance> listAssurance= new ArrayList<>();
		if(trouveId(idVehicule)==null)
			return listAssurance;
		else {
			return  listAssurance=vehiculeRepository.findAssuranceParVehicule(idVehicule);
		}
			
	}*/

}
