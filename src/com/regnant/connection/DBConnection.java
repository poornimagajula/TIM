package com.regnant.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getDBconnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/trustinme", "root", "Admin@123");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql jdbc driver not found");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		return connection;
	}
	

}
