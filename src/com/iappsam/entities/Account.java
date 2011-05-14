package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Account")
public class Account {
	
	@Id
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Account_Type")
	private String accountType;
	
	@Column(name = "Person_ID")
	private int personID;

	public Account() {
		super();
	}
	
	

	public Account(String username, String password, String accountType, int personID) {
		super();
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.personID = personID;
	}



	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAccountType() {
		return accountType;
	}

	public int getPersonID() {
		return personID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

}
