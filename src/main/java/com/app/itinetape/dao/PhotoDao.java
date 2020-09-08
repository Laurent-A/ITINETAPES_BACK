package com.app.itinetape.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.itinetape.modele.Photo;

@Repository
public interface PhotoDao extends JpaRepository<Photo, Integer> {

}
