package org.avr.dao;

import java.util.List;

import org.avr.entities.Carburant;
import org.avr.entities.GareRoutiere;
import org.avr.entities.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface VilleRepository extends JpaRepository<Ville, Long>{
	@Query("select v from Ville v where v.libelle like :x and v.etat=true")
	public Page<Ville> VilleParMc(@Param("x")String mc, Pageable pageable);
	@Query("select g from GareRoutiere g where g.ville.idVille=:x")
	public List<GareRoutiere> GareParVille(@Param("x") Long idGare);
	@Query("select v.idVille from Ville v where v.idVille =:x and v.etat=true")
	public Long trouveId(@Param("x")Long idVille);
	@Query("select count(g.idGare) from GareRoutiere g where g.ville.idVille =:x ")
	public Long compteVille(@Param("x")Long idVille);
	@Transactional
	@Modifying
	@Query("update Ville v set v.etat=false where v.idVille=:x")
	public void deleteVille(@Param("x")Long idVille);
	@Query("select v from Ville v where v.etat=true")
	public List<Ville> findAllVille();
	@Query("select c from Carburant c join c.villes v where v.idVille=:x")
	public List<Carburant> CarburantParVille(@Param("x")Long idVille);
	@Query("select v from Ville v where v.etat=true and v.idVille=:x")
	public Ville villeActive(@Param("x")Long idVille);

}
