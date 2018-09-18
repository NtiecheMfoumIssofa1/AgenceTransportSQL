package org.avr.dao;

import java.time.LocalDate;
import java.util.Date;
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

public interface AssuranceRepository  extends JpaRepository<Assurance, Long>{
	@Transactional
	@Modifying
	@Query("update Assurance a set a.etat=false where a.numAssurance=:x")
	public  void deleteAssurance(@Param("x")Long idassurence);
	@Query("select a from Assurance a where a.etat=true")
	public List<Assurance> findAllAssurance();
	@Query("select a from Assurance a where a.etat=true and a.lieuAssurance like :x")
	public Page<Assurance> AssurenceParMc(@Param("x")String mc, Pageable pageable);
	@Query("select a from Assurance a where a.etat=true and a.numAssurance=:x")
	public Assurance getAssurance(@Param("x")Long id);
	@Query("select a.numAssurance from Assurance a where a.etat=true and a.numAssurance=:x")
	public Long trouveId(@Param("x")Long id);
	@Query("select v from Vehicule v join v.assurances a where a.etat=true and a.dateExpiration=:x")
	public List<Vehicule> getAllVehiculeParDate(@Param("x")LocalDate date);
	@Query("select v from Vehicule v join v.assurances a where a.etat=true and a.dateExpiration between :x and :y")
	public List<Vehicule> getAllVehiculeDeuxDate(@Param("x")LocalDate date1,@Param("y")LocalDate date2);

}
