package org.avr.metier;

import java.util.List;

import org.avr.entities.Carburant;
import org.avr.entities.GareRoutiere;
import org.avr.entities.Ville;
import org.springframework.data.domain.Page;

public interface VilleMetier {
	public Ville saveVille(Long idRegion, Ville v);
	public Ville updateVille(Long idregion, Long idVille, Ville v);
	public boolean deleteVille(Long idville);
	public List<Ville> getAllVille();
	public Page<Ville> VilleParMc(String mc, int page, int size);
	public Ville getById(Long idVille);
	public List<GareRoutiere> GareParVille(Long idVille);
	public Long trouveId(Long idVille);
    public List<Carburant> getCaburantParVille(Long idVille);
    public Ville addCarburantToVille(Long idVille, Long idCarb);
    public boolean getVille(Long idVille);
}
