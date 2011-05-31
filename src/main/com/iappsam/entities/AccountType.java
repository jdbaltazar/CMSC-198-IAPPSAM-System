package com.iappsam.entities;

public enum AccountType {

	SYSTEM_ADMIN("System Administrator"), SPSO_PERSONNEL("SPSO Personnel"), NON_SPSO_PERSONNEL_HEAD("Non-SPSO Personnel (Head)"), NON_SPSO_PERSONNEL_EMPLOYEE("Non-SPSO Personnel (Employee)");

	private String name;

	private AccountType(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
