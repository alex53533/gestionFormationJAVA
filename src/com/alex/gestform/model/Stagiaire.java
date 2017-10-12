package com.alex.gestform.model;

import java.util.List;

public class Stagiaire {
	private static int nbrStagiaire = 0;
	private int id, cp, tel;
	private String nom, prenom, telephone, adresse, ville, mail;

	List<Formation> formations;

        public Stagiaire(int cp, String telephone, String nom, String prenom, String adresse, String ville, String mail) {
		this.cp = cp;
		this.telephone = telephone;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.mail = mail;
		this.id = nbrStagiaire;
		nbrStagiaire++;
	}
        
	public Stagiaire(int cp, String telephone, String nom, String prenom, String adresse, String ville, String mail,
			List<Formation> formations) {
		this.cp = cp;
		this.telephone = telephone;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.mail = mail;
		this.formations = formations;
		this.id = nbrStagiaire;
		nbrStagiaire++;
	}

	public Stagiaire(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public static int getNbrStagiaire() {
		return nbrStagiaire;
	}

	public static void setNbrStagiaire(int nbrStagiaire) {
		Stagiaire.nbrStagiaire = nbrStagiaire;
	}

        public Stagiaire(int cp, int tel, String nom, String prenom, String adresse, String ville, String email) {
                this.cp = cp;
		this.tel = tel;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		mail = email;
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

    public Object getLibelle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getlibelle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
