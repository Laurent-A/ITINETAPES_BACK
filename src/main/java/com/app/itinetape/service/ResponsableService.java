package com.app.itinetape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.itinetape.dao.ResponsableDao;
import com.app.itinetape.exception.ApiNotFoundException;
import com.app.itinetape.modele.Responsable;


@Service
public class ResponsableService {
	
	@Autowired
	public ResponsableDao responsableDao;
	
	public List<Responsable> listeResponsable(){
		return this.responsableDao.findAll();
	}
	
	public Responsable afficherResponsable(Integer id) {
		return responsableDao.findById(id).orElseThrow(() -> new ApiNotFoundException("responsable", "id", id));
	}
	
	public Responsable ajouterResponsable(Responsable responsable) {
		return responsableDao.save(responsable);
	}
	
	public Responsable modifierResponsable(Integer id, Responsable responsableDetails) {
		Responsable responsable = responsableDao.findById(id).orElseThrow(() -> new ApiNotFoundException("responsable", "id", id));
		
		responsable.setLogin(responsableDetails.getLogin());
		responsable.setMdp(responsableDetails.getMdp());
		
		Responsable modifResponsable = responsableDao.save(responsable);
		
		return modifResponsable;
	}
	
	public void suppressionResponsable(Integer id) {
		Responsable responsable = responsableDao.findById(id).orElseThrow(() -> new ApiNotFoundException("responsable", "id", id));
		responsableDao.delete(responsable);
	}

}
