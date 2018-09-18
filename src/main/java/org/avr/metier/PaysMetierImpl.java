package org.avr.metier;

import java.util.List;

import org.avr.dao.PaysRepository;
import org.avr.entities.Pays;
import org.avr.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaysMetierImpl implements PaysMetier {
	@Autowired
	private PaysRepository paysRepository;

	@Override
	public Pays savePays(Pays p) {
		p.setEtat(true);
		return paysRepository.save(p);
	}

	public List<Pays> getAllpays() {
		// TODO Auto-generated method stub
		return paysRepository.findAllPays();
	}

	@Override
	public Pays updatePays(Long id,Pays p) {
		if(id==null){
			new RuntimeException("l' indentifiant ne doit etre null!");
			return p;
		}else if(trouveId(id)==null){
			new RuntimeException(" l'identifiant de ce pays n'exixte pas dans la base de donnée!!!");
			return p;
		}else{
			 p.setIdPays(id);
			 p.setEtat(true);
			  return paysRepository.save(p);	
		}    	
	}

	@Override
	public boolean deletePays(Long id) {
		if(id==null){
			new RuntimeException("l' indentifiant ne doit etre null!");
			return false;
		}else if(trouveId(id)==null){
			new RuntimeException(" l'identifiant de ce pays n'exixte pas dans la base de donnée!!!");
			return false;
		}else if(paysRepository.compteRegion(id)!=0){
			new RuntimeException(" ce Pays ne peut être supprimé car il est clé etrangère dans d'autre table !!!");
			return false;
		}else {
			paysRepository.deletePays(id);
			return true;
		}
	}

	@Override
	public Page<Pays> paysParMc(String mc,int page, int size) {
		return paysRepository.chercherMC("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Pays getPays(Long id) {
		// TODO Auto-generated method stub
		return paysRepository.getOne(id);
	}

	@Override
	public List<Region> RegionParPays(Long idPays) {
		// TODO Auto-generated method stub
		return paysRepository.RegionParPays(idPays);
	}

	@Override
	public Long trouveId(Long idPays) {
		 return paysRepository.trouveId(idPays);
	}
	
	

}
