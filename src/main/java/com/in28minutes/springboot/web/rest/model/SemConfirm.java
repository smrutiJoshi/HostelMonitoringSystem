package com.in28minutes.springboot.web.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="semconfirm")
public class Semconfirm implements java.io.Serializable {

	private String semconfirmid;
	private String rollno;
	private String sem;
	private boolean isChecked;
	private Register register;
	
	public Register getRegister() {
		return register;
	}


	public void setRegister(Register register) {
		this.register = register;
	}


	public Semconfirm() {
		
	}
	
	
public Semconfirm(String rollno,String sem,boolean isChecked) {
		this.rollno=rollno;
		this.sem=sem;
		this.isChecked=isChecked;
	}


	@Id
	@GeneratedValue
	@Column(name = "SEMCONFIRMID")
	public String getSemconfirmid() {
		return semconfirmid;
	}
	public void setSemconfirmid(String semconfirmid) {
		this.semconfirmid = semconfirmid;
	}
	
	@Column(name = "ROLLNO", nullable = false)
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	
	@Column(name = "SEM", nullable = false)
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	
	@Column(name = "ISCHECKED", nullable = false)
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
}
