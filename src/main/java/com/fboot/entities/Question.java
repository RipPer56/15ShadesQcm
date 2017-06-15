package com.fboot.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {
	
	private int ID;
	private String enonce ;
	private String indice;
	private Qcm qcm;
	private List<Choix> choix;
	
	
	public Question(){
		
	}
	public Question(int iD, String enonce, String indice) {
		ID = iD;
		this.enonce = enonce;
		this.indice = indice;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	
	@ManyToOne
	@JoinColumn(name = "idQcm")
	public Qcm getQcm() {
		return qcm;
	}
	public void setQcm(Qcm qcm) {
		this.qcm = qcm;
	}
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	public List<Choix> getChoix() {
		return choix;
	}
	public void setChoix(List<Choix> choix) {
		this.choix = choix;
	}
	
	
}
