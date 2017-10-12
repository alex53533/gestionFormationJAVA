package com.alex.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;
import com.alex.gestform.model.Formation;
import java.sql.Date;

public class FormationDAO {

	public static void save(Formation formation) {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
            try{
		stm = c.prepareStatement(
				"INSERT INTO formation (libelle, description, nbr_heures, lieu, date_debut) VALUES (?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, formation.getLibelle());
		stm.setString(2, formation.getDescription());
		stm.setInt(3, formation.getNbrHeure());
		stm.setString(4, formation.getLieu());
		stm.setDate(5, (Date) formation.getDateDebut());

		stm.executeUpdate();
                
	        PreparedStatement stm2 = c.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM formation");
                    ResultSet rs = stm2.executeQuery();
                    if (rs.next()) {
			formation.setId(rs.getInt("MAX_ID"));
                    }
                    stm.close();
                    
                   
                } catch (Exception e) {
                    e.printStackTrace();
                } 
        }

	public static void update(Formation formation, int j){

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
            try{
		stm = c.prepareStatement(
				"UPDATE formation SET libelle=?, description=?, nbr_heures=?, lieu=? , date_debut=? WHERE id=?");
		stm.setString(1, formation.getLibelle());
		stm.setString(2, formation.getDescription());
		stm.setInt(3, formation.getNbrHeure());
		stm.setString(4, formation.getLieu());
		stm.setDate(5, (Date) formation.getDateDebut());
                stm.setInt(6, j);

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
			stm = c.prepareStatement("DELETE FROM formation WHERE id = ?");
			stm.setInt(1, i);

			stm.executeUpdate();

		} catch (SQLException e) {
			// pb if here
			
		}
	}

	// finAll
	// Creation nouvel class sous de list<nom_liste> nom_instance
	public static List<Formation> findAll() {
		// connection a la BDD
		Connection c = JDBConnect.getConnection();
		// instance de de la list(tableau)
		List<Formation> ps = new ArrayList<>();
		// avant ma query, je declare que je vais essayer de declarer un état
		Statement stm;
		try {
			// création de l'etat
			stm = c.createStatement();
			// envoi la query
			// execute de la requete
			ResultSet rs = stm.executeQuery("SELECT * FROM formation");
			// tant que tu as des reponse tourne
			while (rs.next()) {
				int id = rs.getInt("id");
				String libelle = rs.getString("libelle");
				// il le stock dans f
				Formation f = new Formation(id, libelle);
				// et on les ajoutes dans ps, qui est objet liste
				ps.add(f);
			}
			// on close List
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// on retourne le resultat
		return ps;
	}

}
