package com.hu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class jdbcuntil {

	
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	static
	{
		ResourceBundle resourceBundle=ResourceBundle.getBundle("jdbc");
		driverClass=resourceBundle.getString("driver");
		url=resourceBundle.getString("url");
		user=resourceBundle.getString("user");
		password=resourceBundle.getString("password");
		
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnetion() throws SQLException{
		
		return  DriverManager.getConnection(url, user, password);
		
	}
}
