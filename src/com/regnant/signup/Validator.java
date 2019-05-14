package com.regnant.signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.regnant.connection.DBConnection;

public class Validator {
	public boolean checkSignUp(String mailid,String mobile) {
		String query="select * from trustinme.user_tbl where Email_id=? && Mobile=?";
		
		try {
			Connection connection=DBConnection.getDBconnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, mailid);
			pstmt.setString(2, mobile);
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
		if(u.first_name==""||u.last_name==""||u.city==""||u.state==""||u.email_id==""||u.mobile==""||u.pincode==""||u.pan_no==""||u.password=="") {
			return false;
		}
		else
			return true;		
	}
	
	public boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
	}
	
	public boolean isValidMobile(String Mobile) {
		if(Mobile.contains("0")||Mobile.contains("1")||Mobile.contains("2")||Mobile.contains("3")||Mobile.contains("4")||Mobile.contains("5")||Mobile.contains("6")||Mobile.contains("7")||Mobile.contains("8")||Mobile.contains("9")) {
			return true;
		}
		else
			return false;
	}
	
//	public static void main(String[] args) {
//		Validator v=new Validator();
//		if(v.isValidEmailAddress("test.com")) {
//		System.out.println("Checked");
//		}else
//			System.out.println("Not");
//	}
		
}
