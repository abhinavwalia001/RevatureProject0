package com.aw.bank.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.aw.bank.db.Dbutil;

public class EmployeeOperation {

	public void viewcoustmerdetails() {
		Connection con = Dbutil.getConnection();
		try {
			Statement st =con.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from Coustmer;");
			
		//	System.out.println("Coustmer Details :"+rs);
			while(rs.next())
			{      
				   
			       
			       System.out.println("Coustmer Id : "+rs.getInt(1));
			       System.out.println("Name : "+rs.getString(2)+"   "+rs.getString(3));
			       System.out.println("Addhar Card No: "+rs.getString(4));
			       System.out.print("Mobile No : "+rs.getString(5));
			       System.out.print(" Email : "+rs.getString(6));
			       System.out.println("\nCity : "+rs.getString(7));
			       System.out.print(" Pincode : "+rs.getString(8));
			       System.out.println("Balance"+rs.getString(10));
			       System.out.println("*********************************");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pendings() {
		
		Connection con = Dbutil.getConnection();
		
		try {
			Statement st =con.createStatement();
			Statement st1 =con.createStatement();
			Statement st2 =con.createStatement();
			Statement st3 =con.createStatement();
			Statement st4 =con.createStatement();
			ResultSet rs = st.executeQuery("Select * from Application where status='pending';");
			//int i=0;
			Scanner sc = new Scanner(System.in);
			while(rs.next())
			{      
				   int j=rs.getInt(1);
			       System.out.println("Coustmer Details :");
			       System.out.println("Application : "+rs.getInt(1));
			       System.out.println("Name : "+rs.getString(2)+" "+rs.getString(3));
			       System.out.println("Addhar Card No: "+rs.getString(4));
			       System.out.print("Mobile No : "+rs.getString(5));
			       System.out.print("Email : "+rs.getString(6));
			       System.out.println("City : "+rs.getString(7));
			       System.out.print("Pincode : "+rs.getString(8));
			       System.out.println("Balance"+rs.getString(10));
			       System.out.println("*********************************");
			       System.out.println("Enter 1 to Accept Or Enter any Number To reject");
			       int i = sc.nextInt();
			       if(i==1)
			       {
			       st1.executeUpdate("Update Application set status='accept' where appId="+j);
			    	
			    	PreparedStatement stm = con.prepareStatement("insert into Coustmer(fname,lname,addCardNo,mobileno,email,city,pincode,password,balance,status) values(?,?,?,?,?,?,?,?,?,?);");
			    	  stm.setString(1,rs.getString(2));
					  stm.setString(2,rs.getString(3));
					  stm.setString(3,rs.getString(4));
					  stm.setString(4,rs.getString(5));
					  stm.setString(5,rs.getString(6));
					  stm.setString(6,rs.getString(7));
					  stm.setString(7,rs.getString(8));
					  stm.setString(8,rs.getString(9));
					  stm.setInt(9, rs.getInt(10)); 
					  stm.setString(10,"accepted");
					  /*
			    	  stm.setString(1,rs.getString(1));
					  stm.setString(2,rs.getString(2));
					  stm.setString(3,rs.getString(3));
					  stm.setString(4,rs.getString(4));
					  stm.setString(5,rs.getString(5));
					  stm.setString(6,rs.getString(6));
					  stm.setString(7,rs.getString(7));
					  stm.setString(8,rs.getString(8));
					  stm.setInt(9, rs.getInt(9)); 
					  stm.setString(10,rs.getString(10));*?*/
			    	
			    	
			    	int success=stm.executeUpdate();
			    	if(success!=0)
			    	{
			    		ResultSet rs1= st2.executeQuery("select * from Coustmer where addCardNo="+rs.getString(4));
			    		rs1.next();
			    		st3.executeUpdate("Insert into map values("+rs.getInt(1)+","+rs1.getInt(1)+");");
			    	}
			       }
			       else
			       {
			    	   st4.executeUpdate("Update set status='reject' where appId="+rs.getInt(1));
			       }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void showlog() {
		Connection con = Dbutil.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery("select * from translog;");
			while(rs.next())
			{
				System.out.println("CoustmerId :"+rs.getInt(1)+" Transaction Type:"+rs.getString(2)+" Ammount :"+rs.getInt(3)+" To / from :"+rs.getInt(4) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
