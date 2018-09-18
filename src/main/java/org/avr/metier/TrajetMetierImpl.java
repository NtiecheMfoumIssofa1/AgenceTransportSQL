package org.avr.metier;

import java.util.ArrayList;
import java.util.List;

import org.avr.dao.GareRoutiereRepository;
import org.avr.dao.TrajetRepository;
import org.avr.entities.GareRoutiere;
import org.avr.entities.Trajet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class TrajetMetierImpl implements TrajetMetier {
	@Autowired
	private TrajetRepository trajetRepository;
	@Autowired
    private GareRoutiereRepository gareRepository;
	
	@Override
	public Trajet saveTrajet(Trajet t) {
		t.setEtat(true);
		return trajetRepository.save(t);
	}

	@Override
	public Trajet updateTrajet(Long idTrajet, Trajet t) {
		if(trouveId(idTrajet)==null){
			return t;
		}else{
			t.setIdtrajet(idTrajet);
			t.setEtat(true);
			return trajetRepository.save(t);
		}
		
	}

	@Override
	public boolean deleteTrajet(Long idTrajet) {
		if(trouveId(idTrajet)==null){
			return false;
		}else if(trajetRepository.compteTrajet(idTrajet)!=0){
			return false;
		}else{
			trajetRepository.deleteTrajet(idTrajet);
			return true;
		}
		
	}

	@Override
	public Trajet getById(Long idTrajet) {
		Trajet t =trajetRepository.getOne(idTrajet);
		return t;
	}

	@Override
	public List<Trajet> getAllTrajet() {
		// TODO Auto-generated method stub
		return trajetRepository.findAllTrajet();
	}

	@Override
	public Page<Trajet> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return trajetRepository.chercherTrajetParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Trajet addTrajetToGare(Long idGare, Long idTrajet) {
		GareRoutiere g=gareRepository.getOne(idGare);
		Trajet t=trajetRepository.getOne(idTrajet);
		g.getTrajets().add(t);
		t.getGareRoutieres().add(g);
		gareRepository.save(g);
		trajetRepository.save(t);
		return t;
	}

	@Override
	public List<Trajet> TrajetParGare(Long idGare) {
		List<Trajet> listTrajet= new ArrayList<>();
		listTrajet=trajetRepository.TrajetParGare(idGare);
		return listTrajet;
	}

	@Override
	public Long trouveId(Long id) {
		// TODO Auto-generated method stub
		return trajetRepository.trouveid(id);
	}

}
