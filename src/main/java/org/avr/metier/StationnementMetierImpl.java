package org.avr.metier;

import java.util.ArrayList;
import java.util.List;

import org.avr.dao.StationnementRepository;
import org.avr.dao.TrajetRepository;
import org.avr.entities.Stationnement;
import org.avr.entities.Trajet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StationnementMetierImpl implements StationnementMetier{
	@Autowired
	private StationnementRepository stationnementRepository;
	@Autowired
	private TrajetRepository trajetRepository;

	@Override
	public Stationnement saveStationnement(Long idtrajet, Stationnement s) {
		Trajet t =trajetRepository.getOne(idtrajet);
		s.setTrajet(t);
		s.setEtat(true);
		return stationnementRepository.save(s);
	}

	@Override
	public Stationnement updateStationnement(Long idtrajet, Long idStat, Stationnement s) {
		if(trouveId(idStat)==null){
			return s;
		}else{
			Trajet t =trajetRepository.getOne(idtrajet);
			s.setTrajet(t);
			s.setIdStationnement(idStat);
			s.setEtat(true);
			return stationnementRepository.save(s);
		}
		
	}

	@Override
	public boolean deleteStationnement(Long idStat) {
		if(trouveId(idStat)==null){
			return false;
		}else{
			stationnementRepository.deleteStat(idStat);
			return true;
		}
		
	}

	@Override
	public List<Stationnement> getAllStationnement() {
		// TODO Auto-generated method stub
		return stationnementRepository.findAllStationnement();
	}

	@Override
	public Page<Stationnement> chercherStat(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return stationnementRepository.StationnementParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public List<Stationnement> StationnementParTrajet(Long idTrajet) {
		List<Stationnement> listStat=new ArrayList<>();
		listStat=stationnementRepository.stationnementPartrajet(idTrajet);
		return listStat;
	}

	@Override
	public Long trouveId(Long idStat) {
		// TODO Auto-generated method stub
		return stationnementRepository.trouveId(idStat);
	}

}
