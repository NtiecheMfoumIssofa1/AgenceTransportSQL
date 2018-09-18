package org.avr.metier;

import java.util.List;

import org.avr.entities.TypeVehicule;
import org.avr.entities.Vehicule;
import org.springframework.data.domain.Page;

public interface TypeVehiculeMetier {
	public TypeVehicule saveTypeV(TypeVehicule t);
	public TypeVehicule updateTypeV(Long idType,TypeVehicule t);
	public boolean deleteTypeV(Long idType);
	public Page<TypeVehicule> TypeVehiculeParMc(String mc, int page, int size);
	public List<TypeVehicule> getAllTypeV();
	public TypeVehicule getById(Long idType);
	public Page<Vehicule> getVehiculeParType(Long id, int page, int size);
	public Long trouveId(Long idType);

}
