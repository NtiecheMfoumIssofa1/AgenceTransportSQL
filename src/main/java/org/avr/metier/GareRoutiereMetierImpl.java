package org.avr.metier;

import java.util.List;

import org.avr.dao.GareRoutiereRepository;
import org.avr.dao.VilleRepository;
import org.avr.entities.GareRoutiere;
import org.avr.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GareRoutiereMetierImpl implements GareRoutiereMetier{
	@Autowired
	public GareRoutiereRepository gareRoutiereRepository;
	@Autowired
    public VilleRepository villeRepository;
	
	@Override
	public GareRoutiere saveGare(Long idVile, GareRoutiere g) {
		Ville v =villeRepository.getOne(idVile);
		g.setVille(v);
		g.setEtat(true);
		return gareRoutiereRepository.save(g);
	}

	@Override
	public GareRoutiere updateGare(Long idVile,Long idGare, GareRoutiere g) {
		if(trouveId(idGare)==null){
			return g;
		}else{
			Ville v =villeRepository.getOne(idVile);
			g.setVille(v);
			g.setIdGare(idGare);
			g.setEtat(true);
			return gareRoutiereRepository.save(g);
		}
		
	}

	@Override
	public boolean deleteGare(Long idGare) {
		if(trouveId(idGare)==null){
			return false;
		}else if(gareRoutiereRepository.compteTrajet(idGare)!=0){
			return false;
		}else{
			gareRoutiereRepository.deleteGare(idGare);
			return true;
		}
		
	}

	@Override
	public List<GareRoutiere> getAllGare() {
		// TODO Auto-generated method stub
		return gareRoutiereRepository.findAllGare();
	}

	@Override
	public Page<GareRoutiere> GareRoutierParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return gareRoutiereRepository.GareRoutiereMC("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public GareRoutiere getById(Long idGare) {
		GareRoutiere g=gareRoutiereRepository.getOne(idGare);
		return g;
	}

	@Override
	public Long trouveId(Long idGare) {
		// TODO Auto-generated method stub
		return gareRoutiereRepository.trouveId(idGare);
	}
	
}
