package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.po.Content;
import com.util.DBHelper;

public class ContentDAO {
	
	ArrayList<Content> list = new ArrayList<Content>();
	public ArrayList<Content> getInformation() throws SQLException {
		String sql = "select * from users";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Content content = new Content();
			content.setUsername(rs.getString("username"));
			content.setPassword(rs.getString("password"));
			content.setSex(rs.getString("sex"));
			content.setSchool(rs.getString("school"));
			content.setHeight(rs.getInt("height"));
			content.setWeight(rs.getInt("weight"));
			list.add(content);
		}
		return list;
	}
}
