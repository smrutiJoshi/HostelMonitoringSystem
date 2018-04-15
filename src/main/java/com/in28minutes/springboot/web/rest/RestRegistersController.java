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

import com.in28minutes.springboot.web.rest.model.Registers;
import com.in28minutes.springboot.web.rest.dao.RegistersDao;

@RestController
@RequestMapping("/registerMapping")
public class RestRegistersController {
	@Autowired
	 DataSource dataSource;
	
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public @ResponseBody Integer register(@RequestBody Registers registers)  throws IOException, JAXBException {
		
		RegistersDao registersDao =  new RegistersDao();
		return registersDao.insertUser(dataSource,registers);
	}

//	@RequestMapping(value="details",method=RequestMethod.GET)
//	public @ResponseBody Integer getDetails(@RequestBody Registers registers)  throws IOException, JAXBException {
//		
//		RegistersDao registersDao =  new RegistersDao();
//		return registersDao.getRequestedStudents(dataSource,registers);
//	}

}
