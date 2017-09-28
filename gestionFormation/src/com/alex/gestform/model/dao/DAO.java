// package com.waki.gestform.model.dao;
//
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
//
// public class DAO {
// public static void save(Pays p) throws Exception {
//
// Connection c = JDBConnect.getConnection();
// PreparedStatement stm;
//
// stm = c.prepareStatement("INSERT INTO pays (nom) VALUES (?)",
// Statement.RETURN_GENERATED_KEYS);
// stm.setString(1, p.getNom());
//
// stm.execute();
// ResultSet rs = stm.getGeneratedKeys();
//
// if (rs.next()) {
// p.setId(rs.getInt(1));
// }
// stm.close();
//
// }
// }
