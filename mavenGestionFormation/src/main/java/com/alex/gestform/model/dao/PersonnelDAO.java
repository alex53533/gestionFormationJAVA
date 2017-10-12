package com.alex.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.alex.gestform.model.Personnel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonnelDAO {

	public static void save(Personnel personnel) {
		// connection à la base
		Connection c = JDBConnect.getConnection();
		// declaration de la query
		PreparedStatement stm;
		// assemblage de la connection et de la prepa pour injecter la query (ça
		// créé un object??)
		try {
                    stm = c.prepareStatement(
                                    "INSERT INTO personnel (nom, prenom, user, MDP, role, email) VALUES (?, ?, ?, ?, ?, ?)",
                                    Statement.RETURN_GENERATED_KEYS);
                    stm.setString(1, personnel.getNom());
                    stm.setString(2, personnel.getPrenom());
                    stm.setString(3, personnel.getUser());
                    stm.setString(4, personnel.getMDP());
                    stm.setString(5, personnel.getRole());
                    stm.setString(6, personnel.getEmail());

                    stm.executeUpdate();
                    
                    PreparedStatement stm2 = c.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM personnel");
                    ResultSet rs = stm2.executeQuery();
                    if (rs.next()) {
			personnel.setId(rs.getInt("MAX_ID"));
                    }
                    stm.close();
                    
                   
                } catch (Exception e) {
                    e.printStackTrace();
                } 
	}
	
	  public static void update(Personnel personnel, int j) { 
	  
                Connection c = JDBConnect.getConnection();
                PreparedStatement stm;

                try {
                    stm = c.prepareStatement("UPDATE personnel SET nom=?, prenom=?, user=? WHERE id=?"); 
                    stm.setString(1, personnel.getNom());    
                    stm.setString(2, personnel.getPrenom());
                    stm.setString(3, personnel.getUser());
                    stm.setInt(4, j);

                    stm.executeUpdate();
                    stm.close();
                 } catch (Exception e) {
                    e.printStackTrace();
                }
	  
            }
	  
	  public static void delete(int i) { 
                Connection c = JDBConnect.getConnection();
                PreparedStatement stm;
                
                try { 
                    stm =  c.prepareStatement("DELETE FROM personnel WHERE id = ?");
                    stm.setInt(1, i);
                    stm.executeUpdate();
                }
                catch (SQLException e) {
                    // pb if here throw new
                                    }
          }
          
          public static List<Personnel> findAll() {
		// connection a la BDD
		Connection c = JDBConnect.getConnection();
		// instance de de la list(tableau)
		List<Personnel> ps = new ArrayList<>();
		// declare que je vais essayer de declarer un état
		Statement stm;
		try {
			// création de l'etat
			stm = c.createStatement();
			// execute de la requete
			ResultSet rs = stm.executeQuery("SELECT * FROM personnel");
			// tant que tu as des reponse tourne
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				// il le stock dans f
				Personnel s = new Personnel(id, nom, prenom);
				// et on les ajoutes dans ps, qui est objet liste
				ps.add(s);
			}
			// on close List
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// on retourne le resultat
		return ps;
	}
	  
          
	 /* // finAll // Creation nouvel class sous de list<nom_liste> nom_instance
	  public static List<Personnel> findAll() { // connection a la BDD
                Connection c = JDBConnect.getConnection(); // instance de de la list(tableau) 
                List<Personnel> ps = new ArrayList<Personnel>(); // avant ma query,
                //je declare que je vais essayer de declarer un état Statement stm; try {
                // création de l'etat 
                PreparedStatement stm = c.createStatement(); // j'envoie la query
                String sql = "select * from formateur"; // execute de la requete
                ResultSet rs = stm.executeQuery(sql); // tant que tu as des reponse
                // tourne 
                while (rs.next()) { 
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom"); 
                    String user = rs.getString("user"); // il le stock dans f Personnel
                    p = new Personnel(nom, prenom, user); // et on les ajoutes dans ps, qui est objet
                     // liste 
                     ps.add(p); } // on close List
                rs.close();
	  
	  } catch (SQLException e) { throw new RuntimeException(e); } // on
	  //retourne le resultat 
        return ps; }*/

    //public static void delete(Personnel personnel) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
	 
}
