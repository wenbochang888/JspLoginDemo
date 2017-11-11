package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.C3P0;

public abstract class AbsDAO {

	PreparedStatement stmt = null;
	ResultSet rs = null;
	static Connection conn = null;
	
	static {
		try {
			conn = C3P0.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}







