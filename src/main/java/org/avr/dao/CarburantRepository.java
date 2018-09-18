package org.avr.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.avr.entities.Carburant;
import org.avr.entities.Vehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CarburantRepository extends JpaRepository<Carburant, Long> {
	@Query("select c.idCarb from Carburant c where c.etat=true and c.idCarb=:x")
	public Long trouveId(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Carburant c set c.etat=false where c.idCarb=:x")   
	public void deleteCarburant(@Param("x")Long id); 
	@Query("select c from Carburant c where c.etat=true and c.descripltionCarb like :x")
	public Page<Carburant> CarburantParMc(@Param("x")String mc, Pageable pageable);
	@Query("select c from Carburant c where c.etat=true")
	public List<Carburant> findAllCarburant();
	@Query("select v from Vehicule v where v.etat=true and v.carburants.dateCarb=:x")
	public List<Vehicule> getCarbuVehiculeParDate(@Param("x")LocalDate date);
	@Query ("select v from Vehicule v where v.etat=true and v.carburants.idCarb=:x")
	public List<Vehicule> getVehicule(@Param("x")Long id);
	@Query("select c from Carburant c where c.etat=true and c.idCarb=:x") 
	public Carburant carburantActive(@Param("x")Long idCarb);
	@Query("select c from Carburant c where c.etat=true and c.dateCarb=:x")
	public List<Carburant> getCarbParDate(@Param("x")LocalDate date);

}
