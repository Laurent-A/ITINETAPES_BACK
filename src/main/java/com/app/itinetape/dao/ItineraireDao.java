package com.app.itinetape.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.itinetape.modele.Etape;
import com.app.itinetape.modele.Itineraire;

@Repository
public interface ItineraireDao extends JpaRepository<Itineraire, Integer> {
	
	@Query(value="delete from etape e where e.id_itineraire=?1", nativeQuery= true)
	public List<Etape> effacerEtapeParItineraire(Integer id_itineraire);

}
