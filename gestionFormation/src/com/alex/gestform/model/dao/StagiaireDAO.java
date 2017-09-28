package com.waki.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.waki.gestform.model.Stagiaire;

public class StagiaireDAO {

	public static void save(Stagiaire stagiaire) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;

		stm = c.prepareStatement(
				"INSERT INTO stagiaire (nom, prenom, adresse, ville, mail, CP, telephone) VALUES (?,?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, stagiaire.getNom());
		stm.setString(2, stagiaire.getPrenom());
		stm.setString(3, stagiaire.getAdresse());
		stm.setString(4, stagiaire.getVille());
		stm.setString(5, stagiaire.getMail());
		stm.setInt(6, stagiaire.getCp());
		stm.setString(7, stagiaire.getTelephone());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			stagiaire.setId(rs.getInt(1));
		}
		stm.close();

	}

	public static void update(Stagiaire stagiaire) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;

		stm = c.prepareStatement("UPDATE stagiaire SET nom=?, prenom=?, adresse=?, ville=? WHERE id=?");
		stm.setString(1, stagiaire.getNom());
		stm.setString(2, stagiaire.getPrenom());
		stm.setString(3, stagiaire.getAdresse());
		stm.setString(4, stagiaire.getVille());
		stm.setInt(5, stagiaire.getId());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			stagiaire.setId(rs.getInt(1));
		}
		stm.close();

	}

	public static void delete(int i) throws Exception {
		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		try {
			stm = c.prepareStatement("DELETE FROM stagiaire WHERE id = ?");
			stm.setInt(1, i);

			stm.executeUpdate();

		} catch (SQLException e) {
			// pb if here
			throw new Exception("pb lors de la suppression de stagiaire:" + e.getMessage());
		}
	}

	// finAll
	// Creation nouvel class sous de list<nom_liste> nom_instance
	public static List<Stagiaire> findAll() {
		// connection a la BDD
		Connection c = JDBConnect.getConnection();
		// instance de de la list(tableau)
		List<Stagiaire> ps = new ArrayList<>();
		// declare que je vais essayer de declarer un état
		Statement stm;
		try {
			// création de l'etat
			stm = c.createStatement();
			// j'envois la query
			String sql = "select * from Formation";
			// execute de la requete
			ResultSet rs = stm.executeQuery(sql);
			// tant que tu as des reponse tourne
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				// il le stock dans f
				Stagiaire s = new Stagiaire(id, nom, prenom);
				// et on les ajoutes dans ps, qui est objet liste
				ps.add(s);
			}
			// on close List
			rs.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		// on retourne le resultat
		return ps;
	}

}
