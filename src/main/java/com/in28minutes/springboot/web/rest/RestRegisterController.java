//package com.in28minutes.springboot.web.rest;
//
//import java.io.IOException;
//
//import javax.sql.DataSource;
//import javax.xml.bind.JAXBException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.in28minutes.springboot.web.model.Register;
//import com.in28minutes.springboot.web.rest.dao.RegisterDao;
//
//@RestController
//@RequestMapping("/registerMapping")
//
//public class RestRegisterController {
//
//	@Autowired
//	 DataSource dataSource;
//	
//	
//	@RequestMapping(value="register",method=RequestMethod.POST)
//	public @ResponseBody Integer register(@RequestBody Register register)  throws IOException, JAXBException {
//		
//		RegisterDao registerDao =  new RegisterDao();
//		return registerDao.insertUser(dataSource,register);
//		
//	}
//}
//
