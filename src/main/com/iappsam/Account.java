package com.iappsam;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@Column(name = "Username")
	private String username;

	@Column(name = "Password")
	private String password;

	@Column(name = "Acquainted")
	private boolean acquainted;

	@Column(name = "Account_Type")
	private AccountType type;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Person_ID")
	private Person person;

	public Account() {
		super();
	}

	public Account(String username, String password, AccountType type, Person person) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.person = person;
	}

	public String getUsername() {
		return username;
	}

	public boolean comparePassword(String word) {
		return password.equals(word);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AccountType getType() {
		return type;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAcquainted() {
		return acquainted;
	}

	public void setAcquainted(boolean acquainted) {
		this.acquainted = acquainted;
	}

}
