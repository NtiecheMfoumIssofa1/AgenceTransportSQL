package org.avr.dao;

import java.util.List;

import org.avr.entities.Pays;
import org.avr.entities.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PaysRepository  extends JpaRepository<Pays, Long>{
	@Query("select p from Pays p where p.libellePays like :x and p.etat=true")
	public Page<Pays> chercherMC(@Param("x")String mc, Pageable pageable);
	@Query("select r from Region r where r.pays.idPays=:x and r.etat=true")
	public List<Region> RegionParPays(@Param("x") Long idPays);
	@Query("select p.idPays from Pays p where p.idPays =:x and p.etat=true")
	public Long trouveId(@Param("x")Long idPays);
	@Query("select count(r.idRegion) from Region r  where r.pays.idPays=:x and r.etat=true")
	public Long compteRegion(@Param("x")Long idPays);
	@Query("select p from Pays p where p.etat = true")
	public List<Pays> findAllPays();
	@Transactional
	@Modifying
	@Query("update Pays p set p.etat=false where p.idPays=:x")
	public void deletePays(@Param("x")Long idPays);

}
