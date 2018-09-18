package org.avr.metier;

import java.util.List;

import org.avr.entities.Region;
import org.avr.entities.Ville;
import org.springframework.data.domain.Page;

public interface RegionMetier {
	public Region saveRegion(Long idPays, Region r);
	public Region updateRegion(Long idPays, Long idRegion, Region r);
	public boolean deleteRegion(Long idRegion);
	public List<Region> getAllRegion();
	public Page<Region> RegionParMC( String mc, int page, int size);	
    public Region getRegion(Long id);
    public List<Ville> VilleParRegion(Long idRegion);
    public Long trouveId(Long idRegion);
}
