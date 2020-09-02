package com.app.itinetape.modele;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "etape")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Etape implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String description;
	@NotNull
	private String nom;
	private String qrCode;
	private Integer totalfavori;
	@NotNull
	private Integer ordreEtape;
	
	@OneToOne
	@JoinColumn( name="id_itineraire" )
	private Itineraire itineraire;

	
	public Etape() {
		super();
	}

	public Etape(Integer id, String description, String nom, String qrCode, Integer totalfavori, Integer ordreEtape,
			Itineraire itineraire) {
		super();
		this.id = id;
		this.description = description;
		this.nom = nom;
		this.qrCode = qrCode;
		this.totalfavori = totalfavori;
		this.ordreEtape = ordreEtape;
		this.itineraire = itineraire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public Integer getTotalfavori() {
		return totalfavori;
	}

	public void setTotalfavori(Integer totalfavori) {
		this.totalfavori = totalfavori;
	}

	public Integer getOrdreEtape() {
		return ordreEtape;
	}

	public void setOrdreEtape(Integer ordreEtape) {
		this.ordreEtape = ordreEtape;
	}

	public Itineraire getItineraire() {
		return itineraire;
	}

	public void setItineraire(Itineraire itineraire) {
		this.itineraire = itineraire;
	}
	
	

}
