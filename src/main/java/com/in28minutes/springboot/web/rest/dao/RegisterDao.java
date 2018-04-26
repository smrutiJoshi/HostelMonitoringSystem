package com.in28minutes.springboot.web.rest.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.in28minutes.springboot.web.rest.model.Register;
import com.in28minutes.springboot.web.rest.model.Registers;
import com.in28minutes.springboot.web.rest.model.Semconfirm;
import com.in28minutes.springboot.web.rest.util.HibernateUtil;



public class RegisterDao {
	public Integer insertUser(DataSource dataSource, Registers registers) {
		int isRegistered = 0;
		// ResultSet rs = null;
		Statement stmt = null;
		java.sql.Connection conn = null;

		try {

			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			// String sql = "insert into register
			// values('"+register.getEnrollmentno()+"','"+register.getDob()+"')";
			String sql = "insert into registers values('" + registers.getRollno() + "','" + registers.getName() + "','"
					+ registers.getAddr() + "','" + registers.getPhno() + "','" + registers.getBranch() + "','"
					+ registers.getDob() + "'," + registers.isRegistered() + ",'" + registers.getUsername() + "','"
					+ registers.getPassword() + "')";

			isRegistered = stmt.executeUpdate(sql);

			String sqlString = "insert into semconfirm (rollno,sem,isChecked) values('" + registers.getRollno() + "','"
					+ registers.getSem() + "'," + registers.isChecked() + ")";
			System.out.println("\nSQLSTRING==>" + sqlString);
			isRegistered = stmt.executeUpdate(sqlString);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				stmt.close();
			} catch (Exception e) {
			}

			try {
				conn.close();
			} catch (Exception e) {
			}
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
		register.setDob("14-06-2005");
		register.setName("Vinod");
		register.setUsername("Vinod1234");
		register.setPassword("admin");
		register.setPhno("2318677");
		register.setRegistered(false);
		register.setRollno("219");

		Semconfirm semconfirm = new Semconfirm();
		semconfirm.setChecked(false);
		semconfirm.setRegister(register);
		semconfirm.setRollno("219");
		semconfirm.setSem("1");

		// register.getSemConfirmRecords().add(semconfirm);
		// session.save(semconfirm);

		Semconfirm semconfirm1 = new Semconfirm();
		semconfirm1.setChecked(false);
		semconfirm1.setRegister(register);
		semconfirm1.setRollno("219");
		semconfirm1.setSem("2");

		Semconfirm semconfirm2 = new Semconfirm();
		semconfirm2.setChecked(false);
		semconfirm2.setRegister(register);
		semconfirm2.setRollno("219");
		semconfirm2.setSem("5");

		Set<Semconfirm> semConfirmRecords = new HashSet<Semconfirm>(0);
		semConfirmRecords.add(semconfirm);
		semConfirmRecords.add(semconfirm1);
		semConfirmRecords.add(semconfirm2);

		register.setSemConfirmRecords(semConfirmRecords);
		// session.save(semconfirm1);

		session.save(register);

		session.getTransaction().commit();
		System.out.println("Done");

		return null;

	}

	@SuppressWarnings("unchecked")
	public String getRegistersDetails() {
		 ArrayList<Semconfirm> list=null;
		 String jsonStr=null;
		 System.out.println("Hibernate one to many (Annotation)");
		 Session session = HibernateUtil.getSessionFactory().openSession();

		 Query query=session.createQuery("from Semconfirm where  ischecked= :ischecked");
		 //Query query=session.createQuery("from Semconfirm");
		// query.setParameter("rollno", "219");
		query.setBoolean("ischecked", false);
		// query.setParameter("rno", "219");
		// List list = query.list();
		 
		// Query query=session.createQuery("from Semconfirm ");
		 
		 list=(ArrayList<Semconfirm>) query.list();
		  
//		  Iterator<Register> itr2=list.iterator();  
//	        while(itr2.hasNext()){  
//	        	Register register = itr2.next();
//	           Iterator<Semconfirm> itr3=register.getSemConfirmRecords().iterator();
//	           while(itr3.hasNext()){  
//	        	   Semconfirm semconfirm = itr3.next();
//	        	   //System.out.println("\n\n\n"+semconfirm.getRollno());  
//	        	   
//	           }
//	        }  
	  
	       Gson gson = new Gson();
	      // System.out.println("\n\n\n\nXXXXXXXXXX=>"+list.get(5).getRollno()); 
           //String json = gson.toJson(list.get(5));
           // list.subList(0,0)
           // System.out.println("\n\n\n\njson=>"+json);  
          //  json = gson.toJson(list.subList(0,0))
          //  System.out.println("\n\n\n\njson=>"+json);  		
		   
           
           ObjectMapper mapperObj = new ObjectMapper();
           
           try {
               // get Employee object as a json string
                jsonStr = mapperObj.writeValueAsString(list.get(0));
               System.out.println("######################"+jsonStr);
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           
           session.close();		
		   
		    
		    return jsonStr;
	}
		
	
	/*
	public Integer getRequestedStudents(DataSource dataSource, RegistersDao registers) {
		int isRegistered = 0;
		// ResultSet rs = null;
		Statement stmt = null;
		java.sql.Connection conn = null;

		try {

			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			// String sql = "insert into register
			// values('"+register.getEnrollmentno()+"','"+register.getDob()+"')";
			String sql = "SELECT * FROM registers NATURAL JOIN semconfirm WHERE registers.rollno=semconfirm.rollno AND semconfirm.isChecked=0";
			isRegistered = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				stmt.close();
			} catch (Exception e) {
			}

			try {
				conn.close();
			} catch (Exception e) {
			}
		}

		return isRegistered;

	}
*/
	public static void main(String[] args) {

		DataSource datasource = DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver")
				.url("jdbc:mysql://localhost:3306/hostel").username("root").password("").build();

		RegisterDao registerDao = new RegisterDao();
		registerDao.getRegistersDetails();
	}

}
