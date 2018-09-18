package org.avr.dao;

import java.time.LocalDate;
import java.util.List;

import org.avr.entities.Vehicule;
import org.avr.entities.VisiteTechnique;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VisiteTecniqueRepository extends JpaRepository<VisiteTechnique, Long>{
	@Transactional
	@Modifying
	@Query("update VisiteTechnique v set v.etat=false where v.numvisite=:x")
	public  void deleteVisite(@Param("x")Long idassurence);
	@Query("select v from VisiteTechnique v where v.etat=true")
	public List<VisiteTechnique> findAllVisite();
	@Query("select v from VisiteTechnique v where v.etat=true and v.lieu like :x")
	public Page<VisiteTechnique> VisiteParMc(@Param("x")String mc, Pageable pageable);
	@Query("select v from VisiteTechnique v where v.etat=true and v.numvisite=:x")
	public VisiteTechnique getVisite(@Param("x")Long id);
	@Query("select v.numvisite from VisiteTechnique v where v.etat=true and v.numvisite=:x")
	public Long trouveId(@Param("x")Long id);
	@Query("select v from Vehicule v join v.visiteTechniques a where a.etat=true and a.prochaineVisite=:x")
	public List<Vehicule> getAllVehiculeParDate(@Param("x")LocalDate date);
	@Query("select v from Vehicule v join v.visiteTechniques a where a.etat=true and a.prochaineVisite between :x and :y")
	public List<Vehicule> getAllVehiculeDeuxDate(@Param("x")LocalDate date1,@Param("y")LocalDate date2);


}
