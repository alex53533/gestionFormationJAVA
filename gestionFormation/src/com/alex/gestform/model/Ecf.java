package com.waki.gestform.model;

import java.util.List;

public class Ecf {
	private static int nbrEcf = 0;
	private int id;
	private String nom;
	List<Module> module;

	public Ecf(int id, String nom, List<Module> module) {
		this.id = id;
		this.nom = nom;
		this.module = module;
	}

	public Ecf(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public static int getNbrEcf() {
		return nbrEcf;
	}

	public static void setNbrEcf(int nbrEcf) {
		Ecf.nbrEcf = nbrEcf;
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

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

}
