package com.in28minutes.springboot.web.rest.model;

public class SemConfirms {
	private String rollno;
	private String semconfirmid;
	private String sem;
	private String isChecked;
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getSemconfirmid() {
		return semconfirmid;
	}
	public void setSemconfirmid(String semconfirmid) {
		this.semconfirmid = semconfirmid;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getIsChecked() {
		return isChecked;
	}
	@Override
	public String toString() {
		return "SemConfirms [rollno=" + rollno + ", semconfirmid=" + semconfirmid + ", sem=" + sem + ", isChecked="
				+ isChecked + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isChecked == null) ? 0 : isChecked.hashCode());
		result = prime * result + ((rollno == null) ? 0 : rollno.hashCode());
		result = prime * result + ((sem == null) ? 0 : sem.hashCode());
		result = prime * result + ((semconfirmid == null) ? 0 : semconfirmid.hashCode());
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
		SemConfirms other = (SemConfirms) obj;
		if (isChecked == null) {
			if (other.isChecked != null)
				return false;
		} else if (!isChecked.equals(other.isChecked))
			return false;
		if (rollno == null) {
			if (other.rollno != null)
				return false;
		} else if (!rollno.equals(other.rollno))
			return false;
		if (sem == null) {
			if (other.sem != null)
				return false;
		} else if (!sem.equals(other.sem))
			return false;
		if (semconfirmid == null) {
			if (other.semconfirmid != null)
				return false;
		} else if (!semconfirmid.equals(other.semconfirmid))
			return false;
		return true;
	}
	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}
}
