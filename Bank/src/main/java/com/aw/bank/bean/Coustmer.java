package com.aw.bank.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aw.bank.db.Dbutil;

public class Coustmer {

	
	        public int checkCoustmerCrediential(int username, String password) {
			int check=0;
			
			
			try {
				
				Connection con = Dbutil.getConnection();
				Statement st = con.createStatement();
				

				ResultSet rs = st.executeQuery("select * from Coustmer where coustmerId="+username+" and password='"+password+"';");
				//System.out.println(""+rs);
				if(rs.next())
				{
					check=1;
				}
				//System.out.println("Check"+check);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return check;
	}
}
