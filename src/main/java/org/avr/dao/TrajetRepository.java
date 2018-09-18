package org.avr.dao;

import java.util.List;

import org.avr.entities.Trajet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TrajetRepository extends JpaRepository<Trajet, Long>{
	@Query("select t from Trajet t where t.description like:x and t.etat=true")
	public Page<Trajet> chercherTrajetParMc(@Param("x")String mc, Pageable pageable);
	@Query("select t from Trajet t JOIN t.gareRoutieres g where g.idGare=:x and t.etat=true")//requete sur la table d'association
	public List<Trajet> TrajetParGare(@Param("x")Long idGare);
	@Query("select count (s.idStationnement) from Stationnement s  where s.trajet.idtrajet=:x and s.etat=true")
	public Long compteTrajet(@Param("x")Long idTrajet);
	@Query("select t.idtrajet from Trajet t where t.idtrajet =:x and t.etat=true")
	public Long trouveid(@Param("x")Long idTrajet);
	@Transactional
	@Modifying
	@Query("update Trajet t set t.etat=false where t.idtrajet=:x")
	public void deleteTrajet(@Param("x")Long idTrajet);
	@Query("select t from Trajet t where t.etat=true")
	public List<Trajet> findAllTrajet();
	@Query("select t from Trajet t where t.idtrajet=:x and t.etat=true")
	public Trajet activeTrajet(@Param("x")Long idTrajet);
}
