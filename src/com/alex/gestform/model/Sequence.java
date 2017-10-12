package com.alex.gestform.model;

public class Sequence {
	private int id;
	private String nom, descrition;

	public Sequence(int id, String nom, String descrition) {
		super();
		this.id = id;
		this.nom = nom;
		this.descrition = descrition;
	}

	public Sequence(String nom, String descrition) {
		super();
		this.nom = nom;
		this.descrition = descrition;
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

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

}
