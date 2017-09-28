package com.waki.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.waki.gestform.model.Personnel;

public class PersonnelDAO {

	public static void save(Personnel personnel) throws Exception {
		// connection à la base
		Connection c = JDBConnect.getConnection();
		// declaration de la query
		PreparedStatement stm;
		// assemblage de la connection et de la prepa pour injecter la query (sa créer
		// un object??)
		stm = c.prepareStatement(
				"INSERT INTO personnel (nom, prenom, user, MDP, role, email) VALUES (?, ?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, personnel.getNom());
		stm.setString(2, personnel.getPrenom());
		stm.setString(3, personnel.getUser());
		stm.setString(4, personnel.getMDP());
		stm.setString(5, personnel.getRole());
		stm.setString(6, personnel.getEmail());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			personnel.setId(rs.getInt(rs.getInt(1)));
		}
		stm.close();

	}

	public static void update(Personnel personnel) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;

		stm = c.prepareStatement("UPDATE formateur SET nom=? WHERE id=?");
		stm.setString(1, personnel.getNom());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			personnel.setId(rs.getInt(1));
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
	public static List<Personnel> findAll() {
		// connection a la BDD
		Connection c = JDBConnect.getConnection();
		// instance de de la list(tableau)
		List<Personnel> ps = new ArrayList<>();
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
				String user = rs.getString("user");
				// il le stock dans f
				Personnel p = new Personnel(nom, prenom, user);
				// et on les ajoutes dans ps, qui est objet liste
				ps.add(p);
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
