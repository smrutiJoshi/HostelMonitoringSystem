package com.in28minutes.springboot.web.rest.model;

public class SemConfirm {

	private String semconfirmid;
	private String rollno;
	private String sem;
	private boolean isChecked;
	
	public SemConfirm() {
		
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
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
}
