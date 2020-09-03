package com.app.itinetape.modele;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "photo")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Photo implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String url;
	@NotNull
	private String libelle;
	@NotNull
	private String pseudo_randonneur;
	@NotNull
	private Date date_photo;
	@OneToOne
	@JoinColumn( name="id_etape" )
	private Etape etape;
	
	
	public Photo() {
		super();
	}

	
	public Photo(Integer id, String url, String libelle, String pseudo_randonneur, Date date_photo, Etape etape) {
		super();
		this.id = id;
		this.url = url;
		this.libelle = libelle;
		this.pseudo_randonneur = pseudo_randonneur;
		this.date_photo = date_photo;
		this.etape = etape;
	}


	public Date getDate_photo() {
		return date_photo;
	}


	public void setDate_photo(Date date_photo) {
		this.date_photo = date_photo;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getPseudo_randonneur() {
		return pseudo_randonneur;
	}

	public void setPseudo_randonneur(String pseudo_randonneur) {
		this.pseudo_randonneur = pseudo_randonneur;
	}

	public Etape getEtape() {
		return etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}
	
	
}
