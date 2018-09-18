package org.avr.dao;

import java.util.List;

import org.avr.entities.Region;
import org.avr.entities.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RegionRepository extends JpaRepository<Region, Long> {
	@Query("select r from Region r where r.libelleRegion like :x and r.etat=true")
	public Page<Region> chercherMC(@Param("x")String mc, Pageable pageable);
	@Query("select v from Ville v where v.region.idRegion=:x and v.etat=true")
	public List<Ville> villeParRegion(@Param("x")Long id);
	@Query("select r.idRegion from Region r where r.idRegion=:x and r.etat=true")
	public Long trouveId(@Param("x")Long idRegion);
	@Query("select count (v.idVille) from Ville v where v.region.idRegion=:x and v.etat=true")
	public Long compteVille(@Param("x")Long idRegion);
	@Transactional
	@Modifying
	@Query("update Region r set r.etat=false where r.idRegion=:x")
	public void deleteRegion(@Param("x")Long idRegion);
	@Query("select r from Region r where r.etat=true")
	public List<Region> findAllRegion();
	@Query("select p from Pays p where p.etat=true and p.idPays=:x")
	public boolean etat(@Param("x")Long idPays);
}
