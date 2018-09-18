package org.avr.metier;

import java.util.List;

import org.avr.dao.PaysRepository;
import org.avr.dao.RegionRepository;
import org.avr.entities.Pays;
import org.avr.entities.Region;
import org.avr.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class RegionMetierImpl implements RegionMetier {
	@Autowired
	public RegionRepository regionRepository;
	@Autowired
	public PaysRepository paysRepository;

	@Override
	public Region saveRegion(Long idPays, Region r) {
		Pays p= paysRepository.getOne(idPays);
		r.setPays(p);
		r.setEtat(true);
		p.getRegions().add(r);
		return regionRepository.save(r);
	}


	@Override
	public Region updateRegion(Long idPays, Long idRegion, Region r) {
		if(idPays==null || idRegion==null){
			new RuntimeException(" vérifier les identifiants s'ils ne sont pas vide SVP !!!");
			return r;
		}else if(trouveId(idRegion)==null){
				new RuntimeException(" aucune region n'existe avec cet identifiant !!!");
			return r;
		}else{
			  Pays p=paysRepository.getOne(idPays);
			    r.setPays(p);
				r.setIdRegion(idRegion);
				r.setEtat(true);
			return regionRepository.save(r);
		}   
		  
	}

	@Override
	public boolean deleteRegion(Long idRegion) {
		if(idRegion==null){
			new RuntimeException(" vérifier les identifiants s'ils ne sont pas vide SVP !!!");
			return false;
		}else if(trouveId(idRegion)==null){
				new RuntimeException(" aucune region n'existe avec cet identifiant !!!");
			return false;
		}else if(regionRepository.compteVille(idRegion)!=0){
			new RuntimeException(" cette region ne peut etre supprimée car elle contient des villes !!!");
			return false;
		}else{
			regionRepository.deleteRegion(idRegion);
			return true;
		}
		
	}

	@Override
	public List<Region> getAllRegion() {
		// TODO Auto-generated method stub
		return regionRepository.findAllRegion();
	}

	@Override
	public Page<Region> RegionParMC(String mc, int page, int size) {
		
		return regionRepository.chercherMC("%"+mc+"%", new PageRequest(page, size));
	}


	@Override
	public Region getRegion(Long id) {
		Region r=regionRepository.getOne(id);
		return r;
	}


	@Override
	public List<Ville> VilleParRegion(Long idRegion) {
		// TODO Auto-generated method stub
		return regionRepository.villeParRegion(idRegion);
	}


	@Override
	public Long trouveId(Long idRegion) {
		// TODO Auto-generated method stub
		return regionRepository.trouveId(idRegion);
	}

}
