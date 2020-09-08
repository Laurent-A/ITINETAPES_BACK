package com.app.itinetape.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.itinetape.dao.ItineraireDao;
import com.app.itinetape.exception.ApiNotFoundException;
import com.app.itinetape.modele.Etape;
import com.app.itinetape.modele.Itineraire;


@Service
public class ItineraireService {
	
	@Autowired
	public ItineraireDao itineraireDao;
	
	public List<Itineraire> listeItineraire(){
		return this.itineraireDao.findAll();
	}
	
	public Itineraire afficherItineraire(Integer id) {
		return itineraireDao.findById(id).orElseThrow(() -> new ApiNotFoundException("itineraire", "id", id));
	}
	
	public Itineraire ajouterItineraire(Itineraire itineraire) {
		return itineraireDao.save(itineraire);
	}
	
	@Transactional
	public Itineraire modifierItineraire(Integer id, Itineraire itineraireDetails) {
		Itineraire itineraire = itineraireDao.findById(id).orElseThrow(() -> new ApiNotFoundException("itineraire", "id", id));
		
		itineraire.setNiveau(itineraireDetails.getNiveau());
		itineraire.setNom(itineraireDetails.getNom());
		itineraire.setResponsable(itineraireDetails.getResponsable());
		
		Itineraire modifItineraire = itineraireDao.save(itineraire);
		
		return modifItineraire;
	}
	@Transactional
	public void suppressionItineraire(Integer id) {
		this.effacerEtapeParItineraire(id);
		Itineraire itineraire = itineraireDao.findById(id).orElseThrow(() -> new ApiNotFoundException("itineraire", "id", id));
		itineraireDao.delete(itineraire);
	}
	
	private void effacerEtapeParItineraire(Integer id) {
		this.itineraireDao.effacerEtapeParItineraire(id);
	}


}
