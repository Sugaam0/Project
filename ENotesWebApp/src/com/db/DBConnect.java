package com.db;

import java.sql.DriverManager;
import java.sql.*;
public class DBConnect {
	
	private static Connection conn;
	public static Connection getConn()
	{
		try {
			if(conn == null)
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notehub","root","Hahaha123();");
				
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
