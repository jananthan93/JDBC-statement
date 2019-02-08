package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil2 {
	private static final String DB_DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="root";
	private static final String DB_URL="jdbc:mysql://localhost:3306/jdbcdb";
	private static Connection connection=null;
	private static Properties properties=null;
	static {
		try {
			Class.forName(DB_DRIVER_CLASS);
			connection=DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
		
	}
}
