package com.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0 {
	
	private static final String URL = "jdbc:mysql:///test";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
	static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	static {
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		dataSource.setJdbcUrl(URL);
		try {
			dataSource.setDriverClass(DRIVERCLASS);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = C3P0.getConnection();
		if (conn != null) {
			System.out.println("连接成功");
		} else {
			System.out.println("连接失败");
		}
	}
}
