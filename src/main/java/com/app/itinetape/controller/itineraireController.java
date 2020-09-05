package com.app.itinetape.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.itinetape.modele.Etape;
import com.app.itinetape.modele.Itineraire;
import com.app.itinetape.service.ItineraireService;

@RestController
@RequestMapping("/itinetape")
@CrossOrigin("*")
public class itineraireController {
	
	@Autowired
	private ItineraireService itineraireService;
	
	@GetMapping(value="/itineraire", produces= {"application/json"})
	public List<Itineraire> listeItineraire(){
		return this.itineraireService.listeItineraire();
	}
	
	@GetMapping(value="/itineraire/{id}")
	public Itineraire afficherItineraire(@PathVariable(value = "id") Integer id) {
		return itineraireService.afficherItineraire(id);
	}
	
	@PostMapping("/itineraire")
	public Itineraire ajouterItineraire(@RequestBody Itineraire itineraire) {
	    return itineraireService.ajouterItineraire(itineraire);
	}
	
	@PutMapping("/itineraire/{id}")
	public Itineraire modifierItineraire(@PathVariable(value = "id") Integer id, @RequestBody Itineraire itineraireDetails) {
	    return itineraireService.modifierItineraire(id, itineraireDetails);
	}
	
	@DeleteMapping("/itineraire/{id}")
	public ResponseEntity<?> suppressionItineraire(@PathVariable(value = "id") Integer id) {
		itineraireService.suppressionItineraire(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value="/itineraire/etape/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Etape> afficherEtapeParItineraire(@PathVariable(value = "id") Integer id){
	return this.itineraireService.effacerEtapeParItineraire(id);
	}

}
