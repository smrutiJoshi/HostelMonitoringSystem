package com.in28minutes.springboot.web.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

//import org.hibernate.Session;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import com.in28minutes.springboot.web.rest.model.Registers;
//import com.in28minutes.springboot.web.rest.model.Semconfirms;

import antlr.collections.List;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class RegistersDao<registers> {
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
	 
//	 public Integer insertUser1() {
//		 System.out.println("Hibernate one to many (Annotation)");
//			Session session = HibernateUtil.getSessionFactory().openSession();
//
//			session.beginTransaction();
//
//			    Register register = new Register();
//			    register.setAddr("Satode Valpoi Sattari Goa");
//			    register.setBranch("ETC");
//			    register.setChecked(false);
//			    register.setDob("14-06-2005");
//			    register.setName("Vinod");
//			    register.setPassword("admin");
//			    register.setPhno("2318677");
//			    register.setRegistered(false);
//			    register.setRollno("2005");
//			    register.setSem("2");
//			   
//		        session.save(register);
//		        
//		        Semconfirm semconfirm = new Semconfirm();
//		        semconfirm.setChecked(false);
//		        semconfirm.setRegister(register);
//		        semconfirm.setRollno("2005");
//		        semconfirm.setSem("1");
////		        semconfirm.setSemconfirmid(semconfirmid);
////		        
////		        stockDailyRecords.setPriceOpen(new Float("1.2"));
////		        stockDailyRecords.setPriceClose(new Float("1.1"));
////		        stockDailyRecords.setPriceChange(new Float("10.0"));
////		        stockDailyRecords.setVolume(3000000L);
////		        stockDailyRecords.setDate(new Date());
////		        
////		        stockDailyRecords.setStock(stock);        
////		        stock.getStockDailyRecords().add(stockDailyRecords);
//
//		        register.getSemConfirmRecords().add(semconfirm);
//		        session.save(semconfirm);
//
//			session.getTransaction().commit();
//			System.out.println("Done");
//		 
//		 
//		 return null;
//		 
//	 }
	 
	 public List getRequestedStudents(DataSource dataSource , RegistersDao registers ) {
		 int isRegistered=0;
		 //ResultSet rs = null;
		 Statement stmt = null;
		 java.sql.Connection conn = null;
		List register1 = (List) new ArrayList<registers>();
		 JSONArray jsonArray = new JSONArray();

 
		 try {
			
			conn = dataSource.getConnection();	
			stmt = conn.createStatement();
			//String sql = 	"insert into register values('"+register.getEnrollmentno()+"','"+register.getDob()+"')"; 
			 String sql="SELECT * FROM registers NATURAL JOIN semconfirm WHERE registers.rollno=semconfirm.rollno AND semconfirm.isChecked=0";	
			 ResultSet rs = stmt.executeQuery(sql);
			 while (rs.next()) {
				 
				 Registers register=new Registers();
				 //String rollno=rs.getString("ROLLNO");
					
				 register.setRollno(rs.getString("ROLLNO"));
				 register1.add(register);
				 
				// System.out.println("rollnoLLLLLLLLLLLLLLLLLLLLL"+rollno);
			 }
			// isRegistered=stmt.executeUpdate(sql);
			 
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
		 
		 return register1;
		 
	 }

	
	 
	 
	 
	public static void main(String[] args) {
		 
		 DataSource datasource = DataSourceBuilder.create()
		    		.driverClassName("com.mysql.jdbc.Driver")
		    		.url("jdbc:mysql://localhost:3306/hostel")
		    		.username("root")
		    		.password("")
		    		.build();
		    
		    	
			
		 
		 RegistersDao registersDao = new RegistersDao();
		registersDao.getRequestedStudents(datasource, registersDao);
	 }
	 
}
