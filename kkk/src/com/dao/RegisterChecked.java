package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBHelper;

public class RegisterChecked {
	
	String username = "";
	String password = "";
	
	public static boolean isChecked(String username, String password) throws Exception {
		
		if (username == "" || password == "") {
			return false;
		}
		
		String sql = "select username from users where username = ?";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		if ( rs.next() ) {
			return false;
		}
		
		String sqls = "INSERT INTO users(username, password) values(?, ?)";
		stmt = conn.prepareStatement(sqls);
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.executeUpdate();
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		
		boolean flag = RegisterChecked.isChecked("", "");
		System.out.println(flag);
	}
}







