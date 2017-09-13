package com.po;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBHelper;

public class Users {
	
	String username = null;
	String password = null;
	public Users (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean usersLogin() throws SQLException {
		String sql = "select username,password from users where username = ? and password = ?";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}
}
