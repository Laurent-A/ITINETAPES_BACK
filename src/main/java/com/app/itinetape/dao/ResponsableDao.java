package com.app.itinetape.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.itinetape.modele.Responsable;

@Repository
public interface ResponsableDao extends JpaRepository<Responsable, Integer> {

}
