package com.regnant.signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.regnant.connection.DBConnection;

public class UserCRUDOperations {
	public int AddUser(UserBean u) {
		int rows_count=0;
		try {
			Connection connection=DBConnection.getDBconnection();
			PreparedStatement pstmt=null;
			String insert="insert into trustinme.user_tbl(First_Name,Last_Name,City,State,Email_id,Mobile,Pincode,Pan_No,Password) values(?,?,?,?,?,?,?,?,?)";
			pstmt=connection.prepareStatement(insert);
			pstmt.setString(1,u.getFirstName() );
			pstmt.setString(2, u.getLastName());
			pstmt.setString(3, u.getCity());
			pstmt.setString(4, u.getState());
			pstmt.setString(5, u.getEmail());
			pstmt.setString(6, u.getMobile());
			pstmt.setString(7, u.getPincode());
			pstmt.setString(8, u.getPan());
			pstmt.setString(9, u.getPassword());
			rows_count=pstmt.executeUpdate();
			System.out.println(rows_count+" rows inserted");
			
			connection.close();
			pstmt.close();
			
		} catch (SQLException e) {
			System.out.println("Exception in AddUser");
			e.printStackTrace();
		}	
		return rows_count;
	}
	public List<UserBean> LoginUser() {
		List<UserBean> ulist=new ArrayList<>();
		try {
			Connection connection=DBConnection.getDBconnection();
			PreparedStatement pstmt=null;			
			String Query= "select Email_id,Mobile,Pan_No,Password from trustinme.user_tbl";
			pstmt=connection.prepareStatement(Query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				UserBean u=new UserBean();
				u.setEmail(rs.getString(1));
				u.setMobile(rs.getString(2));
				u.setPan(rs.getString(3));
				u.setPassword(rs.getString(4));
				ulist.add(u);
			}
			rs.close();
			connection.close();
			pstmt.close();
		}catch (SQLException e) {
			System.out.println("Exception in LoginUser");
			e.printStackTrace();
		}
		return ulist;
		
	}
//	public static void main(String[] args) {
//		UserBean u1=new UserBean();
//		u1.first_name="Poornima";
//		u1.last_name="T";
//		u1.city="Tenali";
//		u1.email_id="abc@gmail";
//		u1.state="AP";
//		u1.mobile=9666163164L;
//		u1.pincode=522201L;		
//		u1.pan_no="AMCPT5127D";
//		u1.password="test@123";
//		UserCRUDOperations uop=new UserCRUDOperations();
//		uop.AddUser(u1);
//		
//	}

}
