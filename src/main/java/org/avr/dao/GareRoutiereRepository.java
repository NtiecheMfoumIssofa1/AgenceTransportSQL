package org.avr.dao;

import java.util.List;

import org.avr.entities.GareRoutiere;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface GareRoutiereRepository extends JpaRepository<GareRoutiere, Long> {
	@Query("select g from GareRoutiere g where g.description like:x and g.etat=true")
	public Page<GareRoutiere> GareRoutiereMC(@Param("x")String mc, Pageable pageable);
	@Query("select g.idGare from GareRoutiere g where g.idGare=:x and g.etat=true")
	public Long trouveId(@Param("x")Long idGare); 
	@Query("select count(t.idtrajet) from Trajet t join t.gareRoutieres g where g.idGare=:x and t.etat=true")
	public Long compteTrajet(@Param("x")Long idGare);
	@Transactional
	@Modifying
	@Query("update GareRoutiere g set g.etat=false where g.idGare=:x")
	public void deleteGare(@Param("x")Long idGare);
	@Query("select g from GareRoutiere g where g.etat=true")
	public List<GareRoutiere> findAllGare();
	
}
