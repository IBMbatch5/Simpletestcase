package com.training.bean;

public class CustomerDBBean {
	private String groupname; 
	private String description;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String confirmpassword;
		
	public CustomerDBBean(){
	}
	
	public CustomerDBBean(String groupname, String decsription, 
			String firstname, String lastname, String email, 
			String password, String confirmpassword) {
		super();
		this.groupname = groupname;
		this.description = description;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public String getgroupname() {
		return groupname;
	}

	public void setgroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
	
	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	public String getconfirmpassword() {
		return confirmpassword;
	}

	public void setconfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	
	}

	@Override
	public String toString() {
		return "CustomerDBBean [groupname=" + groupname + ", description=" + description +", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email +", password=" + password +", confirmpassword=" + confirmpassword + "]";
	}
}
