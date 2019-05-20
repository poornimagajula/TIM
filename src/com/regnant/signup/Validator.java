package com.regnant.signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.regnant.connection.DBConnection;

public class Validator {
	public boolean checkSignUp(String mailid,String mobile, String pan) {
		String query="select * from trustinme.user_tbl where Email_id=? || Mobile=? || Pan_No=?";
		
		try {
			Connection connection=DBConnection.getDBconnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, mailid);
			pstmt.setString(2, mobile);
			pstmt.setString(3, pan);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("Exception in Validator");
			e.printStackTrace();
		}
		return true;		
	}
	
}
