package com.alex.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alex.gestform.model.Ecf;

public class ECFDAO {

	public static void save(Ecf ecf) {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
                try{
		stm = c.prepareStatement("INSERT INTO ecf (nom) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, ecf.getNom());

		stm.executeUpdate();
                
                PreparedStatement stm2 = c.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM ECF");
		ResultSet rs = stm2.executeQuery();

		if (rs.next()) {
			ecf.setId(rs.getInt("MAX_ID"));
		}
		stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
	}

	public static void update(Ecf ecf, int j) {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
                try{
		stm = c.prepareStatement("UPDATE ecf SET nom=? WHERE id=?");
		stm.setString(1, ecf.getNom());
                stm.setInt(2, j);

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
			stm = c.prepareStatement("DELETE FROM ecf WHERE id = ?");
			stm.setInt(1, i);

			stm.executeUpdate();

		} catch (SQLException e) {
			// pb if here
			
		}
	}

	// finAll
	// Creation nouvel class sous de list<nom_liste> nom_instance
	public static List<Ecf> findAll() {
		// connection a la BDD
		Connection c = JDBConnect.getConnection();
		// instance de de la list(tableau)
		List<Ecf> ps;
            ps = new ArrayList<>();
		// declare que je vais essayer de declarer un état
		Statement stm;
		try {
			// création de l'etat
			stm = c.createStatement();
			// envoi la query
			// execute de la requete
			ResultSet rs = stm.executeQuery("SELECT * FROM ECF");
			// tant que tu as des reponse tourne
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				// il le stock dans f
				Ecf e = new Ecf(id, nom);
				// et on les ajoutes dans ps, qui est objet liste
				ps.add(e);
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
