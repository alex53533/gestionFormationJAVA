package com.waki.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.waki.gestform.model.Ecf;

public class ECFDAO {

	public static void save(Ecf ecf) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;

		stm = c.prepareStatement("INSERT INTO ecf (nom) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, ecf.getNom());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			ecf.setId(rs.getInt(1));
		}
		stm.close();

	}

	public static void update(Ecf ecf) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;

		stm = c.prepareStatement("UPDATE ecf SET nom=? WHERE id=?");
		stm.setString(1, ecf.getNom());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			ecf.setId(rs.getInt(1));
		}
		stm.close();

	}

	public static void delete(int i) throws Exception {
		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		try {
			stm = c.prepareStatement("DELETE FROM ecf WHERE id = ?");
			stm.setInt(1, i);

			stm.executeUpdate();

		} catch (SQLException e) {
			// pb if here
			throw new Exception("pb lors de la suppression de ecf:" + e.getMessage());
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
			String sql = "select * from ecf";
			// execute de la requete
			ResultSet rs = stm.executeQuery(sql);
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

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		// on retourne le resultat
		return ps;
	}
}
