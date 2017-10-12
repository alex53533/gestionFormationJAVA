package com.alex.gestform.model;

public class Personnel {
	private static int nbrFormateur = 0;
	private int id;
	private String nom = null, prenom = null, user = null, MDP = null,
			role = null, email = null;
        private Personnel personnel;
          
        
        public Personnel(Personnel personnel) {
        this.personnel = personnel;
        }
                
	public Personnel(String nom, String prenom, String user, String mDP,
			String role, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
		this.MDP = mDP;
		this.role = role;
		this.email = email;
	}

	public Personnel(String nom, String prenom, String user) {
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
	}

	public static int getNbrFormateur() {
		return nbrFormateur;
	}

	public static void setNbrFormateur(int nbrFormateur) {
		Personnel.nbrFormateur = nbrFormateur;
	}

    public Personnel(int id, String nom, String prenom) {
        System.out.println("ID : "+ id + ", nom : " + nom + ", prenom : " + prenom );
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMDP() {
		return MDP;
	}

	public void setMDP(String mDP) {
		MDP = mDP;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        

        public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
        }

        public Personnel getPersonnel() {
        return personnel;
        }
        
        @Override
        public String toString() {
        return  nom ;
        }

}
