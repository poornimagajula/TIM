package com.regnant.signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.regnant.connection.DBConnection;

public class Validator {
	public boolean checkSignUp(String mailid,long mobile) {
		String query="select * from trustinme.user_tbl where Email_id=? && Mobile=?";
		
		try {
			Connection connection=DBConnection.getDBconnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, mailid);
			pstmt.setLong(2, mobile);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return false;
			}
			connection.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Exception in Validator");
			e.printStackTrace();
		}
		return true;
		
	}
	public boolean checkObject(UserBean u) {
		if(u.first_name==""||u.last_name==""||u.city==""||u.state==""||u.email_id==""||(u.mobile==0L)||u.pincode==0L||u.pan_no==""||u.password=="") {
			return false;
		}
		return true;
		
	}

}
