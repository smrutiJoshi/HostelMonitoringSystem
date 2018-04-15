package com.in28minutes.springboot.web.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.in28minutes.springboot.web.rest.model.credential;
import com.in28minutes.springboot.web.rest.model.scredential;

public class LoginStudentDao {

	 public boolean validateUser(DataSource dataSource ,com.in28minutes.springboot.web.rest.model.scredential scred ) {
		 boolean isValidUser=false;
		 ResultSet rs = null;
		 Statement stmt = null;
		 java.sql.Connection conn = null;
		 
		 try {
			
			conn = dataSource.getConnection();	
			stmt = conn.createStatement();
			String sql = 	"SELECT * from scredential where username='"+scred.getUsername1()+"' and password='"+scred.getPassword1()+"';"; 
			 
			rs = stmt.executeQuery(sql);
				    while(rs.next()) {
				    	isValidUser=true;
				    }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 finally {
			 try {
				 rs.close();
			 }catch(Exception e ) {}
			 
			 try {
				 stmt.close();
			 }catch(Exception e ) {}
			 
			 try {
				 conn.close();
			 }catch(Exception e ) {}
		 }
		 
		 return isValidUser;
		 
	 }

}
