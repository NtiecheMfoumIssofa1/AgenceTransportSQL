package org.avr.dao;

import java.util.List;

import org.avr.entities.TypeVehicule;
import org.avr.entities.Vehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VehiculeTypeRepository extends JpaRepository<TypeVehicule, Long>{ 
	@Transactional
	@Modifying
	@Query(" update TypeVehicule t set t.etat=false where t.idTypeVehicule=:x")
	public void deleteType(@Param("x")Long idType);
	@Query("select  t from TypeVehicule t where t.etat=true and t.codeTypeVehicule like :x or t.libelleTypeVehicule like :x")
	public Page<TypeVehicule> TypeVehiculeParMc(@Param("x")String mc, Pageable pageable);
	@Query("select  t from TypeVehicule t where t.etat=true")
	public List<TypeVehicule> findAllType();
	@Query("select  v from Vehicule v where v.etat=true and v.typeVehicule.idTypeVehicule=:x") 
	public Page<Vehicule> VehiculeParType(@Param("x")Long id, Pageable pageable);
	@Query("select  t.idTypeVehicule from TypeVehicule t where t.etat=true and t.idTypeVehicule=:x")
	public Long trouveId(@Param("x")Long id);
	@Query("select  count(v.idVehicule) from Vehicule v where v.etat=true and v.typeVehicule.idTypeVehicule=:x")
	public Long compteVehicule(@Param("x")Long id);
	

}
