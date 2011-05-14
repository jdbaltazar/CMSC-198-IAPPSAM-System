package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Account")
public class Account {
	
	@Id
	@Column(name = "Username", nullable = false, length = 60)
	private String username;
	
	@Column(name = "Password", nullable = false, length = 80)
	private String password;
	
	@Column(name = "Account_Type", nullable = false, length = 50)
	private String accountType;
	
	@Column(name = "Person_ID", nullable = false)
	private int personID;

	public Account() {
		super();
	}
	
	public Account(String username, String password, String accountType, int personID) {
		super();
		setUsername(username);
		setPassword(password);
		setAccountType(accountType);
		setPersonID(personID);
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
