package com.fboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professeur {

    private int ID;
    private String nom;
    private String prenom;
    private String email;
    private String passWord;

    public Professeur() {

    }

    public Professeur(int iD, String nom, String prenom, String email,
            String passWord) {
        super();
        ID = iD;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passWord = passWord;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
