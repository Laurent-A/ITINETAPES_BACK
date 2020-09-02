package com.app.itinetape.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.itinetape.modele.Etape;

@Repository
public interface EtapeDao extends JpaRepository<Etape, Integer>{

}
