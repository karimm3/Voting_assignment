package com.crud.ent;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String userName;

	private String password;

	private String EmailId;

	private Long phone;

	
	  private boolean hasVoted;
	  
	  private boolean admin;
	  
	  public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isHasVoted() { return hasVoted; }
	 
	 public void setHasVoted(boolean hasVoted) { this.hasVoted = hasVoted; }


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public register() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
