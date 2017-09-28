package com.waki.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.waki.gestform.model.Formation;

public class FormationDAO {

	public static void save(Formation formation) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;

		stm = c.prepareStatement(
				"INSERT INTO formation (libelle, description, nbr_heures, lieu, date_debut) VALUES (?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, formation.getLibelle());
		stm.setString(2, formation.getDescription());
		stm.setInt(3, formation.getNbrHeure());
		stm.setString(4, formation.getLieu());
		stm.setDate(5, formation.getDateDebut());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			formation.setId(rs.getInt(1));
		}
		stm.close();

	}

	public static void update(Formation formation) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;

		stm = c.prepareStatement(
				"UPDATE formation SET libelle=?, description=?, nbr_heures=?, lieu=? , date_debut=? WHERE id=?");
		stm.setString(1, formation.getLibelle());
		stm.setString(2, formation.getDescription());
		stm.setInt(3, formation.getNbrHeure());
		stm.setString(4, formation.getLieu());
		stm.setDate(5, formation.getDateDebut());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			formation.setId(rs.getInt(1));
		}
		stm.close();

	}

	public static void delete(int i) throws Exception {
		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		try {
			stm = c.prepareStatement("DELETE FROM formation WHERE id = ?");
			stm.setInt(1, i);

			stm.executeUpdate();

		} catch (SQLException e) {
			// pb if here
			throw new Exception("pb lors de la suppression de formation:" + e.getMessage());
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
			// j'envois la query
			String sql = "select * from Formation";
			// execute de la requete
			ResultSet rs = stm.executeQuery(sql);
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

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		// on retourne le resultat
		return ps;
	}

}
