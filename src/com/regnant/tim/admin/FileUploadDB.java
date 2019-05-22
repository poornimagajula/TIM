package com.regnant.tim.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.regnant.tim.connection.DBConnection;

public class FileUploadDB {
	public int filePathUpload(String path) {
		Connection connection=DBConnection.getDBconnection();
		PreparedStatement pstmt=null;
		int row_count=0;
		try {
				String insert_query="insert into trustinme.docfilepath_tbl(File_Path) values(?)";
				pstmt=connection.prepareStatement(insert_query);
				pstmt.setString(1, path);
				row_count=pstmt.executeUpdate();
				System.out.println(row_count+" rows inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row_count;
		
	}

}
