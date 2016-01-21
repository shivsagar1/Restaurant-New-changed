package io.egen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButi {
	
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/res_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "admin" ;
	
	
	static {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Mysql JDBC loaded");
		}
		catch(ClassNotFoundException e ){
			System.err.println("Error loading JDBC driver");
			e.printStackTrace();
			
			
		}
		
	}
	
	
	public static Connection connect()
	{
		
		Connection con = null;
		
		try {
		con =	DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error getting connection");
			e.printStackTrace();
		}
		
		
		
		return con;
		
	}

}
