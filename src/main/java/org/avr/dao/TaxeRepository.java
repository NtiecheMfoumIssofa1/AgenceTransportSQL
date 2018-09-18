package org.avr.dao;

import java.time.LocalDate;
import java.util.List;

import org.avr.entities.Taxe;
import org.avr.entities.Vehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TaxeRepository extends JpaRepository<Taxe, Long>{
	@Transactional
	@Modifying
	@Query("update Taxe t set t.etat=false where t.numTaxe=:x")
	public  void deleteTaxe(@Param("x")Long idTaxe);
	@Query("select t from Taxe t where t.etat=true")
	public List<Taxe> findAllTaxe();
	@Query("select t from Taxe t where t.etat=true and t.description like :x")
	public Page<Taxe> TaxeParMc(@Param("x")String mc, Pageable pageable);
	@Query("select t from Taxe t where t.etat=true and t.numTaxe=:x")
	public Taxe getTaxe(@Param("x")Long id);
	@Query("select t.numTaxe from Taxe t where t.etat=true and t.numTaxe=:x")
	public Long trouveId(@Param("x")Long id);
	@Query("select v from Vehicule v join v.taxes a where a.etat=true and a.expirationtaxe=:x")
	public List<Vehicule> getAllVehiculeParDate(@Param("x")LocalDate date);
	@Query("select v from Vehicule v join v.taxes a where a.etat=true and a.expirationtaxe between :x and :y")
	public List<Vehicule> getAllVehiculeDeuxDate(@Param("x")LocalDate date1,@Param("y")LocalDate date2);


}
