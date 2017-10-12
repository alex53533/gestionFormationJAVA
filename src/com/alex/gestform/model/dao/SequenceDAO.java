package com.alex.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alex.gestform.model.Ecf;
import com.alex.gestform.model.Sequence;

public class SequenceDAO {

	public static void save(Sequence sequence) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
                try{
		stm = c.prepareStatement("INSERT INTO sequence (nom) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, sequence.getNom());

		stm.executeUpdate();
                 PreparedStatement stm2 = c.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM sequence");
		ResultSet rs = stm2.executeQuery();

		if (rs.next()) {
			sequence.setId(rs.getInt("MAX_ID"));
		}
		stm.close();

	}catch (Exception e) {
                    e.printStackTrace();
                } 
        }
	public static void update(Sequence sequence, int j){

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
                try{
		stm = c.prepareStatement("UPDATE sequence SET nom=? WHERE id=?");
		stm.setString(1, sequence.getNom());
                stm.setInt(4, j);

		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			sequence.setId(rs.getInt(1));
		}
		stm.close();

	}catch (Exception e) {
                    e.printStackTrace();
        }
        }

	public static void delete(int i) {
		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		try {
			stm = c.prepareStatement("DELETE FROM sequence WHERE id = ?");
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
		List<Ecf> ps = new ArrayList<>();
		// declare que je vais essayer de declarer un état
		Statement stm;
		try {
			// création de l'etat
			stm = c.createStatement();
			// j'envois la query
			// execute de la requete
			ResultSet rs = stm.executeQuery("SELECT * FROM sequence");
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
