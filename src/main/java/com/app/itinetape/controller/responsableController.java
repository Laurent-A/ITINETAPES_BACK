package com.app.itinetape.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.itinetape.modele.Responsable;
import com.app.itinetape.service.ResponsableService;

@RestController
@RequestMapping("/itinetape")
public class responsableController {
	
	@Autowired
	private ResponsableService responsableService;
	
	@GetMapping(value="/responsable", produces= {"application/json"})
	public List<Responsable> listeResponsable(){
		return this.responsableService.listeResponsable();
	}
	
	@GetMapping(value="/responsable/{id}")
	public Responsable afficherResponsable(@PathVariable(value = "id") Integer id) {
		return responsableService.afficherResponsable(id);
	}
	
	@PostMapping("/responsable")
	public Responsable ajouterResponsable(@RequestBody Responsable responsable) {
	    return responsableService.ajouterResponsable(responsable);
	}
	
	@PutMapping("/responsable/{id}")
	public Responsable modifierResponsable(@PathVariable(value = "id") Integer id, @RequestBody Responsable responsableDetails) {
	    return responsableService.modifierResponsable(id, responsableDetails);
	}
	
	@DeleteMapping("/responsable/{id}")
	public ResponseEntity<?> suppressionResponsable(@PathVariable(value = "id") Integer id) {
		responsableService.suppressionResponsable(id);
		return ResponseEntity.ok().build();
	}

}