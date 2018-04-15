package com.in28minutes.springboot.web.rest.model;

public class scredential {
	    private String username1;
		private String password1;
	    private String logintype1;
	    private boolean isValidUser1;
		public String getUsername1() {
			return username1;
		}
		public void setUsername1(String username1) {
			this.username1 = username1;
		}
		public String getPassword1() {
			return password1;
		}
		public void setPassword1(String password1) {
			this.password1 = password1;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (isValidUser1 ? 1231 : 1237);
			result = prime * result + ((logintype1 == null) ? 0 : logintype1.hashCode());
			result = prime * result + ((password1 == null) ? 0 : password1.hashCode());
			result = prime * result + ((username1 == null) ? 0 : username1.hashCode());
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
			scredential other = (scredential) obj;
			if (isValidUser1 != other.isValidUser1)
				return false;
			if (logintype1 == null) {
				if (other.logintype1 != null)
					return false;
			} else if (!logintype1.equals(other.logintype1))
				return false;
			if (password1 == null) {
				if (other.password1 != null)
					return false;
			} else if (!password1.equals(other.password1))
				return false;
			if (username1 == null) {
				if (other.username1 != null)
					return false;
			} else if (!username1.equals(other.username1))
				return false;
			return true;
		}
		public String getLogintype1() {
			return logintype1;
		}
		public void setLogintype1(String logintype1) {
			this.logintype1 = logintype1;
		}
		public boolean isValidUser1() {
			return isValidUser1;
		}
		public void setValidUser1(boolean isValidUser1) {
			this.isValidUser1 = isValidUser1;
		}
	    
//	    public String getLogintype() {
//			return logintype1;
//		}
//
//		public void setLogintype1(String logintype) {
//			this.logintype1 = logintype;
//		}
//
//		public String getUsername() {
//			return username1;
//		}
//
//		public void setUsername(String username) {
//			this.username1 = username;
//		}
//
//		public String getPassword1() {
//			return password1;
//		}
//
//		public void setPassword1(String password) {
//			this.password1 = password;
//		}
//
//	    
//	    public scredential() {
//	    		super();
//	    }
//	    
//	    public scredential(String username, String password) {
//	        super();
//	        this.username1 = username;
//	        this.password1 = password;
//	       
//	    }
//
//	      @Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + (isValidUser1 ? 1231 : 1237);
//			result = prime * result + ((logintype1 == null) ? 0 : logintype1.hashCode());
//			result = prime * result + ((password1 == null) ? 0 : password1.hashCode());
//			result = prime * result + ((username1 == null) ? 0 : username1.hashCode());
//			return result;
//		}
//
//	   	    @Override
//	    public String toString() {
//	        return String.format(
//	                "scredential [username=%s, password=%s]", username1,
//	                password1);
//	    }
//
//		public boolean isValidUser1() {
//			return isValidUser1;
//		}
//
//		public void setValidUser1(boolean isValidUser1) {
//			this.isValidUser1 = isValidUser1;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			scredential other = (scredential) obj;
//			if (isValidUser1 != other.isValidUser1)
//				return false;
//			if (logintype1 == null) {
//				if (other.logintype1 != null)
//					return false;
//			} else if (!logintype1.equals(other.logintype1))
//				return false;
//			if (password1 == null) {
//				if (other.password1 != null)
//					return false;
//			} else if (!password1.equals(other.password1))
//				return false;
//			if (username1 == null) {
//				if (other.username1 != null)
//					return false;
//			} else if (!username1.equals(other.username1))
//				return false;
//			return true;
//		}
//		
	}


