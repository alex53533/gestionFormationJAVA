package com.alex.gestform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alex.gestform.model.Module;

public class ModuleDAO {

	public static void save(Module module){

		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		// Insert
                try{
		stm = c.prepareStatement("INSERT INTO stagiaire (libelle, description, duree) VALUES (?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, module.getLibelle());
		stm.setString(2, module.getDescription());
		stm.setInt(3, module.getDuree());

		stm.executeUpdate();
                
                PreparedStatement stm2 = c.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM module");
		ResultSet rs;
                    rs = stm2.executeQuery();
		if (rs.next()) {
			module.setId(rs.getInt("MAX_ID"));
		}
		stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } 
	}

	public static void update(Module module, int j) {
		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		// Update
                try{
		stm = c.prepareStatement("UPDATE formation SET libelle=?, description=?, duree=?, resultat=? WHERE id=?");
		stm.setString(1, module.getLibelle());
		stm.setString(2, module.getDescription());
		stm.setInt(3, module.getDuree());
                stm.setInt(4, j);

		stm.execute();
		stm.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
	}
                

	// crea d'une classe delete, en parametre un indice integer
	public static void delete(int i) {
		// connect à la base
		Connection c = JDBConnect.getConnection();
		PreparedStatement stm;
		try {
			stm = c.prepareStatement("DELETE FROM module WHERE id = ?");
			stm.setInt(1, i);

			stm.executeUpdate();

		} catch (SQLException e) {
			// pb if here
		}
	}

	// finAll
	// Creation nouvel class sous de list<nom_liste> nom_instance
	public static List<Module> findAll() {
		// connection a la BDD
		Connection c = JDBConnect.getConnection();
		// instance de de la list(tableau)
		List<Module> ps;
            ps = new ArrayList<>();
		// avant ma query, je declare que je vais essayer de declarer un état
		Statement stm;
		try {
			// création de l'etat
			stm = c.createStatement();
			// envoi la query
			// execute de la requete
			ResultSet rs = stm.executeQuery("SELECT * FROM module");
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

		} catch (Exception e) {
			e.printStackTrace();
		}
		// on retourne le resultat
		return ps;
	}

}
