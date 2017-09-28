package com.waki.gestform.model;

public class Formateur {
	private static int nbrFormateur = 0;
	private int id;
	private String nom, prenom;

	public Formateur(String nom, String prenom) {

		this.nom = nom;
		this.prenom = prenom;
		this.id = nbrFormateur;
		nbrFormateur++;
	}

	public static int getNbrFormateur() {
		return nbrFormateur;
	}

	public static void setNbrFormateur(int nbrFormateur) {
		Formateur.nbrFormateur = nbrFormateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
