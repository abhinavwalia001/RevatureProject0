package com.aw.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aw.bank.bean.CoustmerApplication;
import com.aw.bank.db.Dbutil;

public class ApplyForAccount {

	
	
	 public int apply(CoustmerApplication c)
	 {
		 int result=0;
		 try {
			
		 Connection con = Dbutil.getConnection();
		 
		 
		  PreparedStatement st = con.prepareStatement("insert into Application(fname,lname,addCardNo,mobileno,email,city,pincode,password,balance,status) values(?,?,?,?,?,?,?,?,?,?);");
		  st.setString(1,c.getFname());
		  st.setString(2,c.getlname());
		  st.setString(3,c.getAddarCardNumber());
		  st.setString(4,c.getMob());
		  st.setString(5,c.getEmail());
		  st.setString(6,c.getCity());
		  st.setString(7,c.getPincode());
		  st.setString(8,c.getPassword());
		  st.setInt(9, c.getBalance()); 
		  st.setString(10,c.getStatus());
				
			result = st.executeUpdate();
			
			//con.close();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 return result;
		 
		 
		 
	 }
}
