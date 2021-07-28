package com.aw.bank.operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aw.bank.db.Dbutil;

public class AccountStatusOperation {
 
	public void status() {
		Connection con = Dbutil.getConnection();
		try {
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery("select * from Application;");
			while(rs.next())
			{
				
			       System.out.println("Name : "+rs.getString(2)+"   "+rs.getString(3));
			       System.out.print("Mobile No : "+rs.getString(5));
			       System.out.print(" Email : "+rs.getString(6));
			       System.out.println("\nStatus :"+rs.getString(11));
			       
			       
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
