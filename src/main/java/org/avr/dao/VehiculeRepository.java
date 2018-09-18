package org.avr.dao;

import java.util.List;

import org.avr.entities.Assurance;
import org.avr.entities.Vehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VehiculeRepository  extends JpaRepository<Vehicule, Long>{
	@Query("select  v.idVehicule from Vehicule v where v.etat=true and v.idVehicule=:x")
	public Long trouveId(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Vehicule v set v.etat=false where v.idVehicule=:x")
	public void deleteVehicule(@Param("x")Long id);
	@Query("select v from Vehicule v where v.etat=true and v.numSerie like :x "
			+ "or v.marque like :x or v.model like :x or descriptionVehicule like :x")
    public Page<Vehicule> VehiculeParMc(@Param("x")String mc,Pageable pageable);
	@Query("select v from Vehicule v where v.etat=true")  
	public List<Vehicule> findAllVehicule();
	@Query("select v from Vehicule v where v.idVehicule=:x and v.etat=true ")
	public Vehicule activeVehiculeEtat(@Param("x")Long idVehicule);
	@Query("select v from Vehicule v where v.idVehicule=:x and v.actif=true")
	public Vehicule VehiculeActif(@Param("x")Long idVehicule);
	@Transactional
	@Modifying
	@Query("update Vehicule v set v.actif=true where v.idVehicule=:x")
	public void activeVehicule(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Vehicule v set v.actif=false where v.idVehicule=:x")
	public void desactiveVehicule(@Param("x")Long id);
	
	
}
