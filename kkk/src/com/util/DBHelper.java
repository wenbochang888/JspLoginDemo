package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static final String username = "root";
	private static final String password = "123456";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/test";
	private static Connection conn = null;
	
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
		}
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DBHelper.getConnection();
		if (conn == null) {
			System.out.println("连接失败");
		} else {
			System.out.println("连接成功 ");
		}
	}
}
