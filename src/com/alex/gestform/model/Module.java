package com.alex.gestform.model;

import java.util.List;

public class Module {
	private static int nbrModule = 0;
	private int id, duree;
	private String libelle, description;
	// List<Sequence> sequences;

	Module(int duree, int resultat, String libelle, String description, List<Ecf> ecfs) {
		this.duree = duree;
		this.libelle = libelle;
		this.description = description;
		this.id = nbrModule;
		nbrModule++;
	}

	public Module(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public static int getNbrModule() {
		return nbrModule;
	}

	public static void setNbrModule(int nbrModule) {
		Module.nbrModule = nbrModule;
	}

    public Module(String libelle, String description, int duree) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                this.duree = duree;
		this.libelle = libelle;
		this.description = description;

    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
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

    public String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
