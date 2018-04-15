package com.in28minutes.springboot.web.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	//Create User - in28Minutes/dummy
	
	
	@Value("${spring.datasource.driver}")
	  private String DB_DRIVER;
	  
	  @Value("${spring.datasource.password}")
	  private String DB_PASSWORD;
	  
	  @Value("${spring.datasource.url}")
	  private String DB_URL;
	  
	  @Value("${spring.datasource.username}")
	  private String DB_USERNAME;
	  
	 
	  @Bean(name = "dataSource")
	  public DataSource dataSource() {
	    DataSource datasource = DataSourceBuilder.create()
	    		.driverClassName(DB_DRIVER)
	    		.url(DB_URL)
	    		.username(DB_USERNAME)
	    		.password(DB_PASSWORD)
	    		.build();
	    
	    	
		return datasource;
	  }
	  

		@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("in28Minutes").password("dummy")
                .roles("USER", "ADMIN");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
			http.csrf().disable();
//		http.authorizeRequests().antMatchers("/login").permitAll()
//                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
//                .formLogin();
    }
}
