package com.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0 {

	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=GoodsRespos";
	private static final String USER = "sa";
	private static final String PASSWORD = "123456";
	private static final String DRIVERCLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	static {
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		dataSource.setJdbcUrl(URL);
		try {
			dataSource.setDriverClass(DRIVERCLASS);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}







