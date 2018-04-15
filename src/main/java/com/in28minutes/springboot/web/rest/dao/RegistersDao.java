package com.in28minutes.springboot.web.rest.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hibernate.Session;

import com.in28minutes.springboot.web.rest.model.Register;
import com.in28minutes.springboot.web.rest.model.Registers;
import com.in28minutes.springboot.web.rest.util.HibernateUtil;;

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
	 
	 public Integer insertUser1() {
		 System.out.println("Hibernate one to many (Annotation)");
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			    Register register = new Register();
			    register.setAddr("Satode Valpoi Sattari Goa");
			    register.setBranch("ETC");
			    register.setChecked(false);
			    register.setDob("14-06-2005");
			    register.setName("Vinod");
			    register.setPassword("admin");
			    register.setPhno("2318677");
			    register.setRegistered(false);
			    register.setRollno("2001");
			    register.setSem("2");
			   
		        session.save(register);
		        
		        StockDailyRecord stockDailyRecords = new StockDailyRecord();
		        stockDailyRecords.setPriceOpen(new Float("1.2"));
		        stockDailyRecords.setPriceClose(new Float("1.1"));
		        stockDailyRecords.setPriceChange(new Float("10.0"));
		        stockDailyRecords.setVolume(3000000L);
		        stockDailyRecords.setDate(new Date());
		        
		        stockDailyRecords.setStock(stock);        
		        stock.getStockDailyRecords().add(stockDailyRecords);

		        session.save(stockDailyRecords);

			session.getTransaction().commit();
			System.out.println("Done");
		 
		 
		 return null;
		 
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
