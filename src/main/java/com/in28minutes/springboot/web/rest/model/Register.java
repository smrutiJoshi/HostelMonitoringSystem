package com.in28minutes.springboot.web.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;


import com.in28minutes.springboot.web.rest.model.Semconfirm;

@Entity
@Table(name="REGISTERS")
public class Register implements java.io.Serializable {
	 //private static final GenerationType IDENTITY = null;
	
	  private String rollno;
	  private String name;
	  private String addr;
	  private String phno;
	  private String branch;
	 // private String sem;
	  private String dob;
	  boolean isRegistered;
	 // boolean isChecked;
	  private String username;
	  private String password;
	  
	 
	  private Set<Semconfirm> semConfirmRecords;
	  
	  
	  public Register(){
		  //this.isChecked=false;
		  this.isRegistered=false;
	  }
	  
	  
	  public Register( String rollno,String name, String addr,String phno,String branch,String sem,String dob,boolean isRegistered,boolean isChecked,String username,String password,Set<Semconfirm> semConfirmRecords){
		  this.rollno=rollno;
		  this.name=name;
		  this.addr=addr;
		  this.phno=phno;
		  this.branch=branch;
		 // this.sem=sem;
		  this.dob=dob;
		  //this.isChecked=false;
		  this.isRegistered=false;
		  this.username=username;
		  this.password=password;
		  this.semConfirmRecords=semConfirmRecords;
	  }

	@Column (name ="username")
	  public String getUsername() {
		return username;
	}
	  
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column (name ="Password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Column (name ="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Id
	@Column(name = "rollno", unique = true, nullable = false)
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		
		System.out.println("In Model ########==."+rollno);
		this.rollno = rollno;
	}
	
	@Column (name ="addr")
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Column (name ="phno")
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	
	@Column (name ="branch")
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	/*@Column (name ="sem")
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}*/
	
	@Column (name ="dob")
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Column (name ="isregistered")
	public boolean isRegistered() {
		return isRegistered;
	}
	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	
//	@Column (name ="ischecked")
//	public boolean isChecked() {
//		return isChecked;
//	}
//	public void setChecked(boolean isChecked) {
//		this.isChecked = isChecked;
//	}
	
	
	@OneToMany(mappedBy = "register",cascade = CascadeType.ALL)
    public Set<Semconfirm> getSemConfirmRecords() {
			return semConfirmRecords;
		}

		public void setSemConfirmRecords(Set<Semconfirm> semConfirmRecords) {
			this.semConfirmRecords = semConfirmRecords;
		}
	
//	@Override
//	public String toString() {
//		return "Registers [rollno=" + rollno + ", name=" + name + ", addr=" + addr + ", phno=" + phno + ", branch="
//				+ branch + ", sem=" + sem + ", dob=" + dob + ", isRegistered=" + isRegistered + ", isChecked="
//				+ isChecked + ", username=" + username + ", password=" + password + "]";
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		//result = prime * result + (isChecked ? 1231 : 1237);
		result = prime * result + (isRegistered ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phno == null) ? 0 : phno.hashCode());
		result = prime * result + ((rollno == null) ? 0 : rollno.hashCode());
		//result = prime * result + ((sem == null) ? 0 : sem.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		/*if (isChecked != other.isChecked)
			return false;*/
		if (isRegistered != other.isRegistered)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phno == null) {
			if (other.phno != null)
				return false;
		} else if (!phno.equals(other.phno))
			return false;
		if (rollno == null) {
			if (other.rollno != null)
				return false;
		} else if (!rollno.equals(other.rollno))
			return false;
		/*if (sem == null) {
			if (other.sem != null)
				return false;
		} else if (!sem.equals(other.sem))
			return false;*/
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	  
	

}
