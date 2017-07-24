package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.po.Users;
import com.util.DBHelper;

public class UsersDAO {
	String username = null;
	String password = null;
	public UsersDAO() {}
	
	public UsersDAO(String username, String password) {
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
	
	public Users getInformation(String username) throws SQLException {
		String sql = "select * from users where username = ?";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			Users u = new Users();
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setSex(rs.getString("sex"));
			u.setSchool(rs.getString("school"));
			u.setHeight(rs.getInt("height"));
			u.setWeight(rs.getInt("weight"));
			return u;
		}
		return null;
	}
	
}















