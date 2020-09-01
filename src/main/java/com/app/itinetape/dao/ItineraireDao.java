package com.app.itinetape.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.itinetape.modele.Itineraire;

@Repository
public interface ItineraireDao extends JpaRepository<Itineraire, Integer> {

}
