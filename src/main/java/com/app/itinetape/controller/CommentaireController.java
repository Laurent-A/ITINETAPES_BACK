package com.app.itinetape.controller;

import java.util.List;

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

import com.app.itinetape.modele.Commentaire;
import com.app.itinetape.service.CommentaireService;

@RestController
@RequestMapping("/itinetape")
public class CommentaireController {
	
	
	@Autowired
	private CommentaireService commentaireService;
	
	@GetMapping(value="/commentaire", produces= {MediaType.APPLICATION_JSON_VALUE})
		public List<Commentaire> listCommentaire(){
		return this.commentaireService.listCommentaire();
	}
	
	@GetMapping(value="/commentaire/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
		public Commentaire afficherCommentaire(@PathVariable(value = "id") Integer id) {
		return commentaireService.afficherCommentaire(id);
	}

	@PostMapping("/commentaire")
	public Commentaire ajouterCommentaire(@RequestBody Commentaire commentaire) {
	    return commentaireService.ajouterCommentaire(commentaire);
	}
	
	@PutMapping("/commentaire/{id}")
	public Commentaire modifierCommentaire(@PathVariable(value = "id") Integer id, @RequestBody Commentaire commentaireDetails) {
	    return commentaireService.modifierCommentaire(id, commentaireDetails);
	}
	
	@DeleteMapping("/commentaire/{id}")
	public ResponseEntity<?> suppressionCommentaire(@PathVariable(value = "id") Integer id) {
		commentaireService.suppressionCommentaire(id);
		return ResponseEntity.ok().build();
	}


}
