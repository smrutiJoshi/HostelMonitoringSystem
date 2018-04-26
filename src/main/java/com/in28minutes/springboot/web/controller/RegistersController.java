package com.in28minutes.springboot.web.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.in28minutes.springboot.web.rest.model.Registers;
import com.in28minutes.springboot.web.rest.dao.RegistersDao;

@Controller

public class RegistersController {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTmpl;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showWelcomePage(ModelMap model) {
		return new ModelAndView("register1", "registers", new Registers());
		//model.put("name", getLoggedinUserName());
		//return "login";
	}
	
	
	@RequestMapping(value = "/RegisterController", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("registers")Registers registers, 
			  BindingResult result,  ModelMap model) {
	   
		
		if (result.hasErrors()) {
	        return "error";
	    } 
		String rollno=registers.getRollno();
		String name=registers.getName();
		String addr=registers.getAddr();
		String phno=registers.getPhno();
		String branch=registers.getBranch();
		String sem=registers.getSem();
		String dob=registers.getDob();
		
		
		//String name1 =registers.getRollno();
	//	String dob1 =registers.getRollno();
		//System.out.println("\n888888888888888888888888888888"+rollno);
		
		final String uri = "http://localhost:8888/registerMapping/register";
	
		HttpHeaders headers = new HttpHeaders();
    	
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Registers> requestEntity = new HttpEntity<Registers>(registers, headers);
        ResponseEntity<Integer> result1 = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, Integer.class);
        Integer isRegistered = (Integer)result1.getBody();
        //if(crp.isValidUser())
        	//return "success";
			
        return "success";
	}

	
	
	
}
