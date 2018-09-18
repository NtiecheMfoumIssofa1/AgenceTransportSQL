package org.avr.metier;

import java.util.List;

import org.avr.entities.GareRoutiere;
import org.avr.entities.Trajet;
import org.springframework.data.domain.Page;

public interface TrajetMetier {
	public Trajet saveTrajet(Trajet t);
	public Trajet updateTrajet(Long idTrajet, Trajet t);
	public boolean deleteTrajet(Long idTrajet);
	public Trajet getById(Long idTrajet);
	public List<Trajet> getAllTrajet();
	public Page<Trajet> getParMc(String mc, int page, int size);
	public Trajet addTrajetToGare(Long idGare, Long idTrajet);
	public List<Trajet> TrajetParGare(Long idGare);
	public Long trouveId(Long id);
}
