package com.waki.gestform.main;

import com.waki.gestform.model.Personnel;
import com.waki.gestform.model.dao.JDBConnect;
import com.waki.gestform.model.dao.PersonnelDAO;

public class GestForm {
	public static void main(String[] args) {
		// System.out.println("test");
		JDBConnect jdbc = new JDBConnect();
		// jdbc.getConnection();
		Personnel personnel = new Personnel("Giraud", "Alex", "Alex Kidd");

		try {
			PersonnelDAO.save(personnel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}