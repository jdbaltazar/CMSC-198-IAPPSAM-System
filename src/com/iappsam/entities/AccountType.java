package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Account_Type")
public class AccountType {
	
	@Id
	@Column(name = "Account_Type", nullable = false, length = 50)
	private String accountType;

	public AccountType() {
		super();
	}

	public AccountType(String accountType) {
		super();
		setAccountType(accountType);
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
}
