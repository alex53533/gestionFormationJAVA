package com.waki.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.waki.gestform.model.Formateur;

public class FormateurDAO {
	public static void save(Formateur formateur) throws Exception {
		// connection à la base
		Connection c = JDBConnect.getConnection();
		// declaration de la query
		PreparedStatement stm;
		// assemblage de la connection et de la prepa pour injecter la query (sa créer
		// un object??)
		stm = c.prepareStatement("INSERT INTO formation (nom) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, formateur.getNom());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			formateur.setId(rs.getInt(1));
		}
		stm.close();

	}

	public static void update(Formateur formateur) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;

		stm = c.prepareStatement("UPDATE formation SET nom=? WHERE id=?");
		stm.setString(1, formateur.getNom());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			formateur.setId(rs.getInt(1));
		}
		stm.close();

	}

	public static void delete(int i) throws Exception {
		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		try {
			stm = c.prepareStatement("DELETE FROM formateur WHERE id = ?");
			stm.setInt(1, i);

			stm.executeUpdate();

		} catch (SQLException e) {
			// pb if here
			throw new Exception("pb lors de la suppression du formateur:" + e.getMessage());
		}
	}

	// finAll
	// Creation nouvel class sous de list<nom_liste> nom_instance
	public static List<Formateur> findAll() {
		// connection a la BDD
		Connection c = JDBConnect.getConnection();
		// instance de de la list(tableau)
		List<Formateur> ps = new ArrayList<>();
		// avant ma query, je declare que je vais essayer de declarer un état
		Statement stm;
		try {
			// création de l'etat
			stm = c.createStatement();
			// j'envois la query
			String sql = "select * from formateur";
			// execute de la requete
			ResultSet rs = stm.executeQuery(sql);
			// tant que tu as des reponse tourne
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				// il le stock dans f
				Formateur f = new Formateur(nom, prenom);
				// et on les ajoutes dans ps, qui est objet liste
				ps.add(f);
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
