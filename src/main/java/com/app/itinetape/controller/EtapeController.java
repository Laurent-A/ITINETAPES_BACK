package com.app.itinetape.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.app.itinetape.service.EtapeService;


@RestController
@RequestMapping("/itinetape")
@CrossOrigin("*")
public class EtapeController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(EtapeController.class);
	
	@Autowired
	private EtapeService etapeService;
	
	@GetMapping(value="/etape", produces= {MediaType.APPLICATION_JSON_VALUE})
		public List<Etape> listEtape(){
		return this.etapeService.listEtape();
	}
	
	@GetMapping(value="/etape/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
		public Etape afficherEtape(@PathVariable(value = "id") Integer id) {
		return etapeService.afficherEtape(id);
	}

	@PostMapping("/etape")
	public Etape ajouterEtape(@RequestBody Etape etape) {
	    return etapeService.ajouterEtape(etape);
	}
	
	@PutMapping("/etape/{id}")
	public Etape modifierEtape(@PathVariable(value = "id") Integer id, @RequestBody Etape etapeDetails) {
	    return etapeService.modifierEtape(id, etapeDetails);
	}
	
	@DeleteMapping("/etape/{id}")
	public ResponseEntity<?> suppressionEtape(@PathVariable(value = "id") Integer id) {
		etapeService.suppressionEtape(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value="/etape/itineraire/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Etape> afficherEtapeParItineraire(@PathVariable(value = "id") Integer id){
	return this.etapeService.afficherEtapeParItineraire(id);
	}

}
