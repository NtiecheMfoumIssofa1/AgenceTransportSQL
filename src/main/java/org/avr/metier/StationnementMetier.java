package org.avr.metier;

import java.util.List;

import org.avr.entities.Stationnement;
import org.springframework.data.domain.Page;

public interface StationnementMetier {
	public Stationnement saveStationnement(Long idtrajet, Stationnement s);
	public Stationnement updateStationnement(Long idtrajet, Long idStat, Stationnement s);
	public boolean deleteStationnement(Long idStat);
	public List<Stationnement> getAllStationnement();
	public Page<Stationnement> chercherStat(String mc, int page, int size);
	public List<Stationnement> StationnementParTrajet(Long idTrajet);
	public Long trouveId(Long idStat);

}
