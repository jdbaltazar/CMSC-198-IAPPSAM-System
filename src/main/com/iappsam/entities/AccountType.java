package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account_Type")
public class AccountType {
	
	public static final String SYSTEM_ADMIN = "System Administrator";
	public static final String SPSO_PERSONNEL = "SPSO Personnel";
	public static final String NON_SPSO_PERSONNEL_HEAD = "Non-SPSO Personnel (Head)";
	public static final String NON_SPSO_PERSONNEL_EMPLOYEE = "Non-SPSO Personnel (Employee)";
	
	@Id
	@Column(name = "Account_Type")
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
