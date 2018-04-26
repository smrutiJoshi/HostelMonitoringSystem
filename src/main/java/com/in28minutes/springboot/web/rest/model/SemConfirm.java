package com.in28minutes.springboot.web.rest.model;

import javax.persistence.Column;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="SEMCONFIRM")
public class Semconfirm implements java.io.Serializable {

	private int semconfirmid;
	private String rollno;
	private String sem;
	private boolean isChecked;
	@JsonBackReference
	private Register register;
	
	


	public Semconfirm() {
		
	}
	
	public Semconfirm(String rollno,String sem,boolean isChecked,Register register) {
		this.rollno=rollno;
		this.sem=sem;
		this.isChecked=isChecked;
		this.register=register;
	}
	
	@ManyToOne
	@JoinColumn(name = "ROLLNO")	
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	

	@Id
	@GeneratedValue
	@Column(name = "SEMCONFIRMID")
	public int getSemconfirmid() {
		return semconfirmid;
	}
	
	public void setSemconfirmid(int semconfirmid) {
		this.semconfirmid = semconfirmid;
	}
	
	
	@Column(name = "ROLLNO",insertable = false, updatable = false)
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
	
	@Column(name = "isCHECKED", nullable = false)
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
}
