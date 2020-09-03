package com.app.itinetape.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.itinetape.modele.Commentaire;

@Repository
public interface CommentaireDao extends JpaRepository <Commentaire, Integer> {

}
