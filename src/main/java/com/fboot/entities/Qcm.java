package com.fboot.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Qcm {
	
	private int ID;
	private String titre;
	private String type;
	private String niveau;
	private double seuil;
	private double duree;
	private List<Question> questions;
	private List<Resultat> resultats;
	
	public Qcm(){
		
	}
	public Qcm(int iD, String titre, String type, String niveau, double seuil,
			double duree) {
		ID = iD;
		this.titre = titre;
		this.type = type;
		this.niveau = niveau;
		this.seuil = seuil;
		this.duree = duree;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public double getSeuil() {
		return seuil;
	}
	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}
	public double getDuree() {
		return duree;
	}
	public void setDuree(double duree) {
		this.duree = duree;
	}
	
	@OneToMany(mappedBy = "qcm", cascade = CascadeType.ALL)
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	@OneToMany(mappedBy = "qcm", cascade = CascadeType.ALL)
	public List<Resultat> getResultats() {
		return resultats;
	}
	public void setResultats(List<Resultat> resultats) {
		this.resultats = resultats;
	}
	
	
}
