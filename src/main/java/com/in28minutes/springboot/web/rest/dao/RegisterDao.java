//package com.in28minutes.springboot.web.rest.dao;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//
//import javax.sql.DataSource;
//
//import org.hibernate.mapping.Map;
//
//import com.in28minutes.springboot.web.model.Register;
//import com.in28minutes.springboot.web.model.credential;
//
//public class RegisterDao {
//	 public Integer insertUser(DataSource dataSource , Register register ) {
//		 int isRegistered=0;
//		 //ResultSet rs = null;
//		 Statement stmt = null;
//		 java.sql.Connection conn = null;
//		 
//		 try {
//			
//			conn = dataSource.getConnection();	
//			stmt = conn.createStatement();
//			String sql = 	"insert into register values('"+register.getEnrollmentno()+"','"+register.getDob()+"')"; 
//			 
//             			
//			isRegistered=stmt.executeUpdate(sql);
//			  
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		 finally {
//			  
//			 try {
//				 stmt.close();
//			 }catch(Exception e ) {}
//			 
//			 try {
//				 conn.close();
//			 }catch(Exception e ) {}
//		 }
//		 
//		 return isRegistered;
//		 
//	 }
//
//
//}
