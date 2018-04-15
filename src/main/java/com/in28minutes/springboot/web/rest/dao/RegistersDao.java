package com.in28minutes.springboot.web.rest.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.in28minutes.springboot.web.rest.model.Registers;;

public class RegistersDao {
	 public Integer insertUser(DataSource dataSource , Registers registers ) {
		 int isRegistered=0;
		 //ResultSet rs = null;
		 Statement stmt = null;
		 java.sql.Connection conn = null;
		 
		 try {
			
			conn = dataSource.getConnection();	
			stmt = conn.createStatement();
			//String sql = 	"insert into register values('"+register.getEnrollmentno()+"','"+register.getDob()+"')"; 
			 String sql="insert into registers values('"+registers.getRollno()+"','"+registers.getName()+"','"+registers.getAddr()+"','"+registers.getPhno()+"','"+registers.getBranch()+"','"+registers.getDob()+"',"+registers.isRegistered()+",'"+registers.getUsername()+"','"+registers.getPassword()+"')";
		
			 isRegistered=stmt.executeUpdate(sql);
			
			 String sqlString="insert into semconfirm (rollno,sem,isChecked) values('"+registers.getRollno()+"','"+registers.getSem()+"',"+registers.isChecked()+")";
			 System.out.println("\nSQLSTRING==>"+sqlString);
			 isRegistered=stmt.executeUpdate(sqlString);    
			
			  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 finally {
			  
			 try {
				 stmt.close();
			 }catch(Exception e ) {}
			 
			 try {
				 conn.close();
			 }catch(Exception e ) {}
		 }
		 
		 return isRegistered;
		 
	 }
	 
	 
	 public Integer getRequestedStudents(DataSource dataSource , RegistersDao registers ) {
		 int isRegistered=0;
		 //ResultSet rs = null;
		 Statement stmt = null;
		 java.sql.Connection conn = null;
		 
		 try {
			
			conn = dataSource.getConnection();	
			stmt = conn.createStatement();
			//String sql = 	"insert into register values('"+register.getEnrollmentno()+"','"+register.getDob()+"')"; 
			 String sql="SELECT * FROM registers NATURAL JOIN semconfirm WHERE registers.rollno=semconfirm.rollno AND semconfirm.isChecked=0";		
			 isRegistered=stmt.executeUpdate(sql);
			
			  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 finally {
			  
			 try {
				 stmt.close();
			 }catch(Exception e ) {}
			 
			 try {
				 conn.close();
			 }catch(Exception e ) {}
		 }
		 
		 return isRegistered;
		 
	 }

}
