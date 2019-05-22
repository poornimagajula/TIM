package com.regnant.tim.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.regnant.tim.connection.DBConnection;

public class DocCRUDOperations {
	public List<DocFileBean> getDoc() {
	Connection connection=DBConnection.getDBconnection();
	String query="select File_Path from trustinme.docfilepath_tbl";
	ResultSet rs=null;
	List<DocFileBean> list= new ArrayList<>();
	try {
		PreparedStatement pstmt=connection.prepareStatement(query);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			DocFileBean db=new DocFileBean();
			db.setFilepath(rs.getString(1));
			list.add(db);			
		}
	} catch (SQLException e) {
		System.out.println("Exception in  get Documents");
		e.printStackTrace();
	}
	return list;	
	}
}
