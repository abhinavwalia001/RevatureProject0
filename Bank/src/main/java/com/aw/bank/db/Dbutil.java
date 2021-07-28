package com.aw.bank.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Dbutil {
	
	public static Connection con;
/*	static String url = "jdbc:mysql://localhost:3306/bank";
	static String username="root";
	static String password="Abhiwalia@1234";*/
	
	public static Connection getConnection(){
		
		String url=null;
		String username=null;
		String password=null;
		try(FileInputStream fis=new FileInputStream("dbconfig.properties");){
			Properties prop=new Properties();
			prop.load(fis);
			url = prop.getProperty("db.url");
			username = prop.getProperty("db.username");
			password = prop.getProperty("db.password");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(con==null)
		{
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		     return con;
		}
		return con;
	}
	
	
	

}
