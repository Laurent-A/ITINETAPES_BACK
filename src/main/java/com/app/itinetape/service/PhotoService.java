package com.app.itinetape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.itinetape.dao.PhotoDao;
import com.app.itinetape.exception.ApiNotFoundException;
import com.app.itinetape.modele.Photo;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoDao photoDao;
	
	public List<Photo> listPhoto() {
		return this.photoDao.findAll();
	}

	public Photo afficherPhoto(Integer id) {
		return photoDao.findById(id).orElseThrow(() -> new ApiNotFoundException("photo", "id", id));
	}

	public Photo ajouterPhoto(Photo photo) {
		return photoDao.save(photo);
	}

	public Photo modifierPhoto(Integer id, Photo photoDetails) {
		Photo photo = photoDao.findById(id).orElseThrow(() -> new ApiNotFoundException("photo", "id", id));

		photo.setUrl(photoDetails.getUrl());
		photo.setLibelle(photoDetails.getLibelle());

		Photo modifPhoto = photoDao.save(photo);

		return modifPhoto;
	}

	public void suppressionPhoto(Integer id) {
		Photo photo = photoDao.findById(id).orElseThrow(() -> new ApiNotFoundException("photo", "id", id));
		photoDao.delete(photo);
	}

}
