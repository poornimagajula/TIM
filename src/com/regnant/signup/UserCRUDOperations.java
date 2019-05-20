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
			
			//connection.close();
			pstmt.close();
			
		} catch (SQLException e) {
			System.out.println("Exception in AddUser");
			e.printStackTrace();
		}	
		return rows_count;
	}
	public List<UserBean> LoginUser(UserBean u) {
		List<UserBean> ulist=new ArrayList<>();
		try {
			Connection connection=DBConnection.getDBconnection();
			PreparedStatement pstmt=null;			
			String Query= "select First_Name,Email_id,Mobile,Pan_No,Password from trustinme.user_tbl where Email_id=? || Mobile=? && Pan_No=? && Password=?";
			pstmt=connection.prepareStatement(Query);
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, u.getMobile());
			pstmt.setString(3, u.getPan());
			pstmt.setString(4, u.getPassword());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				UserBean u1=new UserBean();
				u1.setFirstName(rs.getString(1));
				u1.setEmail(rs.getString(2));
				u1.setMobile(rs.getString(3));
				u1.setPan(rs.getString(4));
				u1.setPassword(rs.getString(5));
				ulist.add(u1);
			}
			
			rs.close();
			connection.close();
			pstmt.close();
			return ulist;
		}catch (SQLException e) {
			System.out.println("Exception in LoginUser");
			e.printStackTrace();
		}
		return ulist;		
	}
	public List<UserBean> userCheck(UserBean u){
		String query="select First_Name,Email_id,Mobile from trustinme.user_tbl where Email_id=?";
		Connection connection=DBConnection.getDBconnection();
		List<UserBean> ulist=new ArrayList<>();
		try {
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, u.getEmail());
			ResultSet rs=pstmt.executeQuery();			
			while(rs.next()) {
				UserBean u1=new UserBean();
				u1.setFirstName(rs.getString(1));
				u1.setEmail(rs.getString(2));
				u1.setMobile(rs.getString(3));
				ulist.add(u1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
		
	}
	public int updatePwd(UserBean u) {
		String query="update trustinme.user_tbl set Password=? where Email_id=?";
		Connection connection=DBConnection.getDBconnection();
		int row_count=0;
		try {
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, u.getPassword());
			pstmt.setString(2,u.getEmail());
			row_count=pstmt.executeUpdate();
			System.out.println(row_count+"rows inserted");
		} catch (SQLException e) {
			System.out.println("Exception in Update Password");
			e.printStackTrace();
		}
		return row_count;
		
	}
//	public static void main(String[] args) {
//		UserBean u1=new UserBean();
//		u1.email_id="poornima.thota31@gmail.com";
//		u1.password="12345";
//		UserCRUDOperations uop=new UserCRUDOperations();
//		int count=uop.updatePwd(u1);
//		System.out.println(count+"*****");
//		
//	}

}
