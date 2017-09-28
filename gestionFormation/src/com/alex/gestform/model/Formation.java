package com.waki.gestform.model;

import java.sql.Date;
import java.util.List;

public class Formation {

	// Declaration des primitives
	private static int nbrFormation = 0;
	private int id, codeFormation; // ID Formation
	private int nbrHeure;

	public int getCodeFormation() {
		return codeFormation;
	}

	// declaration des objets
	private String libelle, description, lieu;
	private Date dateDebut;

	// Constructeur
	Formation(int nbrHeure, String libelle, String description, String lieu, Date dateDebut, List<Module> modules,
			List<Formation> formation) {
		// liaison des primitives et du constructeur
		this.libelle = libelle;
		this.nbrHeure = nbrHeure;
		this.description = description;
		this.lieu = lieu;
		this.dateDebut = dateDebut;
		this.id = nbrFormation;
		nbrFormation++;

	}

	public Formation(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public static int getNbrFormation() {
		return nbrFormation;
	}

	public static void setNbrFormation(int nbrFormation) {
		Formation.nbrFormation = nbrFormation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbrHeure() {
		return nbrHeure;
	}

	public void setNbrHeure(int nbrHeure) {
		this.nbrHeure = nbrHeure;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setCodeFormation(int codeFormation) {
		this.codeFormation = codeFormation;
	}
}
