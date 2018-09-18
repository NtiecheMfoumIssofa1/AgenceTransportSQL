package org.avr.metier;

import java.util.List;

import org.avr.entities.GareRoutiere;
import org.avr.entities.Ville;
import org.springframework.data.domain.Page;

public interface GareRoutiereMetier {
	public GareRoutiere saveGare(Long idVile, GareRoutiere g);
	public GareRoutiere updateGare(Long idVile,Long idGare, GareRoutiere g);
	public boolean deleteGare(Long idGare);
	public List<GareRoutiere> getAllGare();
	public Page<GareRoutiere> GareRoutierParMc(String mc, int page, int size);
	public GareRoutiere getById(Long idGare); 
	public Long trouveId(Long idGare);

}
