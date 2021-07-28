package com.aw.bank.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aw.bank.db.Dbutil;

public class CoustmerOperation {

	
	
	
	public int coustmerbalance(int coustmerId) {
		int balance=0;
		
		Connection con =Dbutil.getConnection();
		
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select balance from coustmer where coustmerId="+coustmerId+";");
			rs.next();
			balance = rs.getInt("balance");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return balance;
		
	}
	public int deposit(int coustmerId,int ammount){
		
		int status=0;
	
		Connection con = Dbutil.getConnection();
		
		try {
			Statement st = con.createStatement();

		 	status =st.executeUpdate("update coustmer set balance=balance+"+ammount+" where coustmerId="+coustmerId+";");
		 	
		 	PreparedStatement pst = con.prepareStatement("insert into translog(coustmerId,transtype,ammount) values(?,?,?);");
		 	pst.setInt(1,coustmerId);
		 	pst.setString(2,"deposit");
		 	pst.setInt(3,ammount);
		 	pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status;
	}
	
	public int withdrawal(int coustmerId,int ammount){
		
		int status=0;
	
		Connection con = Dbutil.getConnection();
		
		try {
			Statement st = con.createStatement();
		 	status =st.executeUpdate("update coustmer set balance=balance-"+ammount+" where coustmerId="+coustmerId+";");
		 	PreparedStatement pst = con.prepareStatement("insert into translog(coustmerId,transtype,ammount) values(?,?,?);");
		 	pst.setInt(1,coustmerId);
		 	pst.setString(2,"withdrawal");
		 	pst.setInt(3,ammount);
		 	pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status;
	}
	
    public int transfer(int coustmerId,int reciverId,int ammount){
		
		int status=0;
	    int status1=0;
	    int status2=0;
		Connection con = Dbutil.getConnection();
		
		try {
			Statement st = con.createStatement();
			Statement st1 = con.createStatement();
		 	status1 =st.executeUpdate("update coustmer set balance=balance-"+ammount+" where coustmerId="+coustmerId+";");
		 	
		 	status2 =st1.executeUpdate("update coustmer set balance=balance+"+ammount+" where coustmerId="+reciverId+";");
		 	
		 	PreparedStatement pst = con.prepareStatement("insert into translog(coustmerId,transtype,ammount,toORfrom) values(?,?,?,?);");
		 	pst.setInt(1,coustmerId);
		 	pst.setString(2,"transfer");
		 	pst.setInt(3,ammount);
		 	pst.setInt(4, reciverId);
		 	pst.executeUpdate();
		 	
		 	PreparedStatement pst1 = con.prepareStatement("insert into translog(coustmerId,transtype,ammount,toORfrom) values(?,?,?,?);");
		 	pst1.setInt(1,reciverId);
		 	pst1.setString(2,"accepted");
		 	pst1.setInt(3,ammount);
		 	pst1.setInt(4,coustmerId);
		 	pst1.executeUpdate();
		 	
		 	if((status1!=0)&&(status2!=0))
		 	{
		 		status=1;
		 	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status;
	}
	
	
}
