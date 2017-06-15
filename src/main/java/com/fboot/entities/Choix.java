package com.fboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Choix {
	
	private int ID;
	private String valeur;
	private boolean correcte;
	private Question question;
	
	public Choix(){
		
	}

	public Choix(int iD, String valeur, boolean correcte) {
		super();
		ID = iD;
		this.valeur = valeur;
		this.correcte = correcte;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public boolean isCorrecte() {
		return correcte;
	}

	public void setCorrecte(boolean correcte) {
		this.correcte = correcte;
	}
	
	@ManyToOne
	@JoinColumn(name = "idQuestion")
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
