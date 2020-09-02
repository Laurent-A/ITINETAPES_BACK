package com.app.itinetape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.itinetape.dao.EtapeDao;
import com.app.itinetape.exception.ApiNotFoundException;
import com.app.itinetape.modele.Etape;

@Service
public class EtapeService {

	@Autowired
	private EtapeDao etapeDao;

	public List<Etape> listEtape() {
		return this.etapeDao.findAll();
	}

	public Etape afficherEtape(Integer id) {
		return etapeDao.findById(id).orElseThrow(() -> new ApiNotFoundException("etape", "id", id));
	}

	public Etape ajouterEtape(Etape etape) {
		return etapeDao.save(etape);
	}

	public Etape modifierEtape(Integer id, Etape etapeDetails) {
		Etape etape = etapeDao.findById(id).orElseThrow(() -> new ApiNotFoundException("etape", "id", id));

		etape.setNom(etapeDetails.getNom());
		etape.setDescription(etapeDetails.getDescription());

		Etape modifEtape = etapeDao.save(etape);

		return modifEtape;
	}

	public void suppressionEtape(Integer id) {
		Etape etape = etapeDao.findById(id).orElseThrow(() -> new ApiNotFoundException("etape", "id", id));
		etapeDao.delete(etape);
	}

}
