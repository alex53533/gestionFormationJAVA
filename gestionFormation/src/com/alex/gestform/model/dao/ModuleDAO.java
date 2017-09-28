package com.waki.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.waki.gestform.model.Module;

public class ModuleDAO {

	public static void save(Module module) throws Exception {

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		// Insert
		stm = c.prepareStatement("INSERT INTO stagiaire (libelle, description, duree, resultat) VALUES (?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, module.getLibelle());
		stm.setString(2, module.getDescription());
		stm.setInt(3, module.getDuree());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			module.setId(rs.getInt(1));
		}
		stm.close();
	}

	public static void update(Module module) throws Exception {
		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		// Update
		stm = c.prepareStatement("UPDATE formation SET libelle=?, description=?, duree=?, resultat=? WHERE id=?");
		stm.setString(1, module.getLibelle());
		stm.setString(2, module.getDescription());
		stm.setInt(3, module.getDuree());

		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			module.setId(rs.getInt(1));
		}
		stm.close();

	}

	// crea d'une classe delete, en parametre un indice integer
	public static void delete(int i) throws Exception {
		// connect à la base
		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		try {
			stm = c.prepareStatement("DELETE FROM module WHERE id = ?");
			stm.setInt(1, i);

			stm.executeUpdate();

		} catch (SQLException e) {
			// pb if here
			throw new Exception("pb lors de la suppression de module:" + e.getMessage());
		}
	}

	// finAll
	// Creation nouvel class sous de list<nom_liste> nom_instance
	public static List<Module> findAll() {
		// connection a la BDD
		Connection c = JDBConnect.getConnection();
		// instance de de la list(tableau)
		List<Module> ps = new ArrayList<>();
		// avant ma query, je declare que je vais essayer de declarer un état
		Statement stm;
		try {
			// création de l'etat
			stm = c.createStatement();
			// j'envois la query
			String sql = "select * from Module";
			// execute de la requete
			ResultSet rs = stm.executeQuery(sql);
			// tant que tu as des reponse tourne
			while (rs.next()) {
				int id = rs.getInt("id");
				String libelle = rs.getString("libelle");
				// il le stock dans f
				Module m = new Module(id, libelle);
				// et on les ajoutes dans ps, qui est objet liste
				ps.add(m);
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
