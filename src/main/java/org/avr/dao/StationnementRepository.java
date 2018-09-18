package org.avr.dao;

import java.util.List;

import org.avr.entities.Stationnement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StationnementRepository extends JpaRepository<Stationnement, Long>{
	@Query("select s from Stationnement s where s.description like :x and s.etat=true")
	public Page<Stationnement> StationnementParMc(@Param("x")String mc, Pageable pageable);
	@Query("select s from Stationnement s where s.trajet.idtrajet =:x and s.etat=true")
	public List<Stationnement> stationnementPartrajet(@Param("x")Long idTrajet);
	@Query("select s.idStationnement from Stationnement s where s.idStationnement=:x and s.etat=true")
	public Long trouveId(@Param("x")Long idStat);
	@Transactional
	@Modifying
	@Query("update Stationnement s set s.etat=false where s.idStationnement=:x ")
	public void deleteStat(@Param("x")Long idStat);
	@Query("select s from Stationnement s where s.etat=true")
	public List<Stationnement> findAllStationnement();

}
