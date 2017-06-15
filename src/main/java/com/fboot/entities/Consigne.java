package com.fboot.entities;

public class Consigne {
	
	private int ID;
	private String modeDeReponse;
	private double bareme;
	private double penalite;
	private Question question;
	
	public Consigne(){
		
	}
	
	public Consigne(int iD, String modeDeReponse, double bareme,
			double penalite, Question question) {
		super();
		ID = iD;
		this.modeDeReponse = modeDeReponse;
		this.bareme = bareme;
		this.penalite = penalite;
		this.question = question;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getModeDeReponse() {
		return modeDeReponse;
	}

	public void setModeDeReponse(String modeDeReponse) {
		this.modeDeReponse = modeDeReponse;
	}

	public double getBareme() {
		return bareme;
	}

	public void setBareme(double bareme) {
		this.bareme = bareme;
	}

	public double getPenalite() {
		return penalite;
	}

	public void setPenalite(double penalite) {
		this.penalite = penalite;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
