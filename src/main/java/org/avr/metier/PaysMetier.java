package org.avr.metier;

import java.util.List;

import org.avr.entities.Pays;
import org.avr.entities.Region;
import org.springframework.data.domain.Page;

public interface PaysMetier {
	public Pays savePays( Pays p);
	public List<Pays> getAllpays();
	public Pays updatePays(Long id, Pays p);
	public boolean deletePays( Long id);
	public Page<Pays> paysParMc(String mc, int page, int size);
	public Pays getPays(Long id);
	public List<Region> RegionParPays(Long idPays);
	public Long trouveId(Long idPays);

}
