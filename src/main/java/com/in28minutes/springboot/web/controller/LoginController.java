package com.in28minutes.springboot.web.controller;

//import  org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.in28minutes.springboot.web.rest.dao.*;
//import com.in28minutes.springboot.web.model.scredential;
//import com.in28minutes.springboot.web.model.scredential;
import com.in28minutes.springboot.web.rest.model.credential;
import com.in28minutes.springboot.web.rest.model.scredential;

@Controller
public class LoginController {

	
	@RequestMapping("/")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
		//return "welcome";
	}
	
//	@RequestMapping("/details")
//	public String getDetails(HttpServletRequest request) {
//		
//		
//		return new ModelAndView("Admin", "viewdetails", new registers());
//		//return "viewdetail";
//		//return "welcome";
//	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showWelcomePage(ModelMap model) {
		return new ModelAndView("login", "credential", new com.in28minutes.springboot.web.rest.model.credential());
		
		//model.put("name", getLoggedinUserName());
		//return "login";
	}
	
	
	@RequestMapping(value = "/LoginController", method = RequestMethod.POST)
	public String getLogin(@Valid @ModelAttribute("credential")credential credential1, 
			  BindingResult result,  ModelMap model) {
	   
		
		if (result.hasErrors()) {
	        return "error";
	    } 
		String userName =credential1.getUsername();
		String password =credential1.getPassword();
		
		final String uri = "http://localhost:8888/loginMapping/all";
		
HttpHeaders headers = new HttpHeaders();
    	
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	RestTemplate restTemplate = new RestTemplate();
        HttpEntity<credential> requestEntity = new HttpEntity<credential>(credential1, headers);
        ResponseEntity<credential> result1 = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, credential.class);
        credential crp = (credential)result1.getBody();
        if(crp.isValidUser())
        	return "Admin";
			System.out.println("\n888888888888888888888888888888"+crp.getUsername());
		
        return "login";
	}
	
	@RequestMapping(value = "/LoginStudentController", method = RequestMethod.POST)
	public String getStudentLogin(@Valid @ModelAttribute("scredential")scredential scredential1, 
			  BindingResult result1,  ModelMap model) {
	   
		
		if (result1.hasErrors()) {
	        return "error";
	    } 
		String userName1 =scredential1.getUsername1();
		String password1 =scredential1.getPassword1();
		
		final String uri = "http://localhost:8888/loginMapping/all";
		
HttpHeaders headers = new HttpHeaders();
    	
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	RestTemplate restTemplate = new RestTemplate();
        HttpEntity<scredential> requestEntity = new HttpEntity<scredential>(scredential1, headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
        System.out.println("############Result#############"+result);
		
        return "success";
	}
	
	
	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
			
		if (principal instanceof UserDetails) {
			 //System.out.println("############Smruti1#############"+((UserDetails) principal).getUsername());
			// System.out.println("############Smruti2#############"+((UserDetails) principal).getPassword());
				
			 return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}


}
