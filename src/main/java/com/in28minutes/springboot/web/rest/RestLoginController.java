package com.in28minutes.springboot.web.rest;

import java.io.IOException;

import javax.sql.DataSource;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.web.rest.model.credential;
import com.in28minutes.springboot.web.rest.dao.LoginDao;



@RestController
@RequestMapping("/loginMapping")
public class RestLoginController {
   
	@Autowired
	 DataSource dataSource;
	
	
	@RequestMapping(value="all",method=RequestMethod.POST)
	public @ResponseBody credential getClientes(@RequestBody credential employee)  throws IOException, JAXBException {
		
		LoginDao LoginDao =  new LoginDao();
		
		//return employee;
if(LoginDao.validateUser(dataSource,employee)){
	employee.setValidUser(true);	
	  }
		return employee;

}

	}
