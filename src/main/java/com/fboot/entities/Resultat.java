package com.fboot.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Resultat {
	
	private int ID;
	private Etudiant etudiant;
	private Qcm qcm;
	private double note;
	
	public Resultat() {
		
	}

	public Resultat(int iD, Etudiant etudiant, Qcm qcm, double note) {
		super();
		ID = iD;
		this.etudiant = etudiant;
		this.qcm = qcm;
		this.note = note;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	@ManyToOne
	@JoinColumn(name = "idEtudiant")
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	@ManyToOne
	@JoinColumn(name = "idQcm")
	public Qcm getQcm() {
		return qcm;
	}

	public void setQcm(Qcm qcm) {
		this.qcm = qcm;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
	
	
	

}
