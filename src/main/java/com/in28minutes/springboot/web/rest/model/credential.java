package com.in28minutes.springboot.web.rest.model;

public class credential {
    private String username;
	private String password;
    private String logintype;
    private boolean isValidUser;
    
    public String getLogintype() {
		return logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    
    public credential() {
    		super();
    }
    
    public credential(String username, String password) {
        super();
        this.username = username;
        this.password = password;
       
    }

      @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        credential other = (credential) obj;
        if (username != other.username) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "credential [username=%s, password=%s]", username,
                password);
    }

	public boolean isValidUser() {
		return isValidUser;
	}

	public void setValidUser(boolean isValidUser) {
		this.isValidUser = isValidUser;
	}
	
}
