package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.po.Content;
import com.util.DBHelper;

public class SearchDAO {
	
	public static Content getInformation(String username) throws SQLException {
		String sql = "select * from users where username = ?";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		Content content = null;
		if (rs.next()) {
			content = new Content();
			content.setUsername(rs.getString("username"));
			content.setPassword(rs.getString("password"));
			content.setSex(rs.getString("sex"));
			content.setSchool(rs.getString("school"));
			content.setHeight(rs.getInt("height"));
			content.setWeight(rs.getInt("weight"));
			
		}
		return content;
	}
}
