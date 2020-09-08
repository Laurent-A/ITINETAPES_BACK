package com.app.itinetape.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.itinetape.modele.Etape;

@Repository
public interface EtapeDao extends JpaRepository<Etape, Integer>{
	
	@Query(value="select * from etape e where e.id_itineraire=?1", nativeQuery= true)
	public List<Etape> etapeParItineraire(Integer id_itineraire);

}
