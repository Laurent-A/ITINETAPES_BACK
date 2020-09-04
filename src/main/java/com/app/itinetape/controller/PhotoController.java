package com.app.itinetape.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.itinetape.modele.Photo;

import com.app.itinetape.service.PhotoService;

@RestController
@RequestMapping("/itinetape")
public class PhotoController {

public static final Logger LOGGER = LoggerFactory.getLogger(EtapeController.class);
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping(value="/photo", produces= {MediaType.APPLICATION_JSON_VALUE})
		public List<Photo> listPhoto(){
		return this.photoService.listPhoto();
	}
	
	@GetMapping(value="/photo/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
		public Photo afficherPhoto(@PathVariable(value = "id") Integer id) {
		return photoService.afficherPhoto(id);
	}

	@PostMapping("/photo")
	public Photo ajouterPhoto(@RequestBody Photo photo) {
	    return photoService.ajouterPhoto(photo);
	}
	
	@PutMapping("/photo/{id}")
	public Photo modifierPhoto(@PathVariable(value = "id") Integer id, @RequestBody Photo photoDetails) {
	    return photoService.modifierPhoto(id, photoDetails);
	}
	
	@DeleteMapping("/photo/{id}")
	public ResponseEntity<?> suppressionPhoto(@PathVariable(value = "id") Integer id) {
		photoService.suppressionPhoto(id);
		return ResponseEntity.ok().build();
	}
}
