package com.waki.gestform.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnect {
	// CTRL + SHIFT + O pour générer les imports
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver O.K.");

			String url = "jdbc:mysql://localhost/gstion_formation";
			String user = "root";
			String passwd = "0000";

			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
