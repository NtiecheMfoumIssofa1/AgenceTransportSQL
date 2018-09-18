package org.avr.metier;

import java.util.List;

import org.avr.dao.CarburantRepository;
import org.avr.dao.RegionRepository;
import org.avr.dao.VilleRepository;
import org.avr.entities.Carburant;
import org.avr.entities.GareRoutiere;
import org.avr.entities.Region;
import org.avr.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VilleMetierImpl implements VilleMetier{
@Autowired	
private VilleRepository villeRepository;
@Autowired
private RegionRepository regionRepository;
@Autowired
private CarburantMetier carburantMetier;
@Autowired
private CarburantRepository carburantRepository;
	@Override
	public Ville saveVille(Long idRegion, Ville v) {
		if(idRegion==null){
			new RuntimeException(" les identifiants ne doivent pas être null!!!");
			return v;
		}else{
			Region r= regionRepository.getOne(idRegion);
			v.setRegion(r);
			v.setEtat(true);
			r.getVilles().add(v);
			return villeRepository.save(v);
		}
		
	}

	@Override
	public Ville updateVille(Long idregion, Long idVille, Ville v) {
		 if(trouveId(idVille)==null){
			new RuntimeException(" la ville avec cette identifiant n'exixte pas!!!");
			return v;
		}else{
			Region r= regionRepository.getOne(idregion);
			v.setRegion(r);
			v.setIdVille(idVille);
			v.setEtat(true);
			return villeRepository.save(v);
		}
		
	}

	@Override
	public boolean deleteVille(Long idville) {
		if(idville==null){
			new RuntimeException(" les identifiants ne doivent pas être null!!!");
			return false;
		}else if(trouveId(idville)==null){
			new RuntimeException(" la ville avec cette identifiant n'exixte pas!!!");
			return false;
		}else if(villeRepository.compteVille(idville)!=0){
			new RuntimeException(" impossible de supprimer cette ville car elle contient des Gares Routières!!!");
			return false;
		}else{
			Ville v=villeRepository.getOne(idville);
			villeRepository.deleteVille(idville);
			return true;
		}
		
	}

	@Override
	public List<Ville> getAllVille() {
		// TODO Auto-generated method stub
		return villeRepository.findAllVille();
	}

	@Override
	public Page<Ville> VilleParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return villeRepository.VilleParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Ville getById(Long idVille) {
		Ville v=villeRepository.getOne(idVille);
		return v;
	}

	@Override
	public List<GareRoutiere> GareParVille(Long idVille) {
		// TODO Auto-generated method stub
		return villeRepository.GareParVille(idVille);
	}

	@Override
	public Long trouveId(Long idVille) {
		// TODO Auto-generated method stub
		return villeRepository.trouveId(idVille);
	}

	@Override
	public List<Carburant> getCaburantParVille(Long idVille) {
		if(trouveId(idVille)==null){
			return null;
		}else{
			return villeRepository.CarburantParVille(idVille);
		}
	
	}

	@Override
	public Ville addCarburantToVille(Long idVille, Long idCarb) {
		if((idVille==null)||(idCarb==null)){
			return null;
		}else if((trouveId(idVille)==null)||(carburantMetier.trouveId(idCarb)==false)){
			return null;
		}else if ((getVille(idVille)==false)||(carburantMetier.getCarb(idCarb)==false)){
			return null;
		}else{
			Ville v=villeRepository.getOne(idVille);
			Carburant c= carburantMetier.getCaburant(idCarb);
			v.getCarburants().add(c);
			c.getVilles().add(v);
			carburantRepository.save(c);
			villeRepository.save(v);
			return v;
		
		}
	}

	@Override
	public boolean getVille(Long idVille) {
		if(villeRepository.villeActive(idVille)==null)
			return false;
		else
			return true; 
	}

}
