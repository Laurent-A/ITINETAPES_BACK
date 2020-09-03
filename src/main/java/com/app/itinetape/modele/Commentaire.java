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
@Table(name = "commentaire")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Commentaire implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String message;
	@NotNull
	private String pseudo_randonneur;
	@NotNull
	private Date date_commentaire;
	@OneToOne
	@JoinColumn( name="id_etape" )
	private Etape etape;
	
	
	public Commentaire() {
		super();
	}


	public Commentaire(Integer id, String message, String pseudo_randonneur, Date date_commentaire, Etape etape) {
		super();
		this.id = id;
		this.message = message;
		this.pseudo_randonneur = pseudo_randonneur;
		this.date_commentaire = date_commentaire;
		this.etape = etape;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPseudo_randonneur() {
		return pseudo_randonneur;
	}


	public void setPseudo_randonneur(String pseudo_randonneur) {
		this.pseudo_randonneur = pseudo_randonneur;
	}


	public Date getDate_commentaire() {
		return date_commentaire;
	}


	public void setDate_commentaire(Date date_commentaire) {
		this.date_commentaire = date_commentaire;
	}


	public Etape getEtape() {
		return etape;
	}


	public void setEtape(Etape etape) {
		this.etape = etape;
	}
	
	
}
