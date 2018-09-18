package org.avr.metier;

import java.util.List;

import org.avr.dao.VehiculeTypeRepository;
import org.avr.entities.TypeVehicule;
import org.avr.entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class TypeVehiculeMetierImpl implements TypeVehiculeMetier{
	@Autowired
	private VehiculeTypeRepository typeVehiculeRepository;
 
	@Override
	public TypeVehicule saveTypeV(TypeVehicule t) {
		t.setEtat(true);
		return typeVehiculeRepository.save(t);
	}

	@Override
	public TypeVehicule updateTypeV(Long idType, TypeVehicule t) {
		if(trouveId(idType)==null){
			return t;
		}else{
			t.setIdTypeVehicule(idType);
			t.setEtat(true);
			return typeVehiculeRepository.save(t);
		}
		
	}

	@Override
	public boolean deleteTypeV(Long idType) {
		if(trouveId(idType)==null){
			return false;
		}else if(typeVehiculeRepository.compteVehicule(idType)!=0){
			return false;
		}else{
			typeVehiculeRepository.deleteType(idType);
			return true;
		}
		
	}

	@Override
	public Page<TypeVehicule> TypeVehiculeParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return typeVehiculeRepository.TypeVehiculeParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public List<TypeVehicule> getAllTypeV() {
		// TODO Auto-generated method stub 
		return typeVehiculeRepository.findAllType();
	}

	@Override
	public TypeVehicule getById(Long idType) {
		TypeVehicule t=typeVehiculeRepository.getOne(idType);
		return t;
	}

	@Override
	public Page<Vehicule> getVehiculeParType(Long id,int page, int size) {
		// TODO Auto-generated method stub
		return typeVehiculeRepository.VehiculeParType(id, new PageRequest(page, size));
	}

	@Override
	public Long trouveId(Long idType) {
		return typeVehiculeRepository.trouveId(idType);
		}

}
