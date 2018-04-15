//package com.in28minutes.springboot.web.controller;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.in28minutes.springboot.web.model.Register;
//import com.in28minutes.springboot.web.model.credential;
//
//@Controller
//public class RegisterController {
//	@Autowired
//	private NamedParameterJdbcTemplate jdbcTmpl;
//
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public ModelAndView showWelcomePage(ModelMap model) {
//		return new ModelAndView("register1", "register", new Register());
//		
//		//model.put("name", getLoggedinUserName());
//		//return "login";
//	}
//	
//	
//	@RequestMapping(value = "/RegisterController", method = RequestMethod.POST)
//	public String registerUser(@Valid @ModelAttribute("register")Register register, 
//			  BindingResult result,  ModelMap model) {
//	   
//		
//		if (result.hasErrors()) {
//	        return "error";
//	    } 
//		String enrollNo =register.getEnrollmentno();
//		String dob =register.getDob();
//		//System.out.println("\n888888888888888888888888888888"+enrollNo+dob);
//		
//		final String uri = "http://localhost:8888/registerMapping/register";
//	
//		HttpHeaders headers = new HttpHeaders();
//    	
//    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//    	headers.setContentType(MediaType.APPLICATION_JSON);
//    	RestTemplate restTemplate = new RestTemplate();
//        HttpEntity<Register> requestEntity = new HttpEntity<Register>(register, headers);
//        ResponseEntity<Integer> result1 = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, Integer.class);
//        Integer isRegistered = (Integer)result1.getBody();
//        //if(crp.isValidUser())
//        	//return "success";
//			
//        return "success";
//	}
//	/*public void registerUser(@ModelAttribute Register register){
//		  StringBuilder sql = new StringBuilder();
//		 // sql.append("INSERT INTO register(enrollmentno,dob) ");
//		  //sql.append("VALUES(:enrollId,:dob) ");
//
//		  Map<String, Object> params = new HashMap<String, Object>();
//		 // params.put("enrollId", register.getEnrollmentno());
//		  params.putAll((Map<? extends String, ? extends Object>) register);
//
//		 // jdbcTmpl.update(sql.toString(), params);
//		*/}
//
