package com.app.itinetape.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.itinetape.modele.Itineraire;

@Repository
public interface ItineraireDao extends JpaRepository<Itineraire, Integer> {
	
	@Query(value="delete from Etape e where e.itineraire.id=?1")
	@Modifying
	public void effacerEtapeParItineraire(Integer id_itineraire);

}
