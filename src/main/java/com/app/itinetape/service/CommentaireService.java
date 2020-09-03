package com.app.itinetape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.itinetape.dao.CommentaireDao;
import com.app.itinetape.exception.ApiNotFoundException;
import com.app.itinetape.modele.Commentaire;

@Service
public class CommentaireService {
	
	@Autowired
	private CommentaireDao commentaireDao;
	
	public List<Commentaire> listCommentaire() {
		return this.commentaireDao.findAll();
	}

	public Commentaire afficherCommentaire(Integer id) {
		return commentaireDao.findById(id).orElseThrow(() -> new ApiNotFoundException("commentaire", "id", id));
	}

	public Commentaire ajouterCommentaire(Commentaire commentaire) {
		return commentaireDao.save(commentaire);
	}
	

	public Commentaire modifierCommentaire(Integer id, Commentaire commentaireDetails) {
		Commentaire commentaire = commentaireDao.findById(id).orElseThrow(() -> new ApiNotFoundException("commentaire", "id", id));

		commentaire.setMessage(commentaireDetails.getMessage());

		Commentaire modifCommentaire = commentaireDao.save(commentaire);

		return modifCommentaire;
	}

	public void suppressionCommentaire(Integer id) {
		Commentaire commentaire = commentaireDao.findById(id).orElseThrow(() -> new ApiNotFoundException("commentaire", "id", id));
		commentaireDao.delete(commentaire);
	}


}
