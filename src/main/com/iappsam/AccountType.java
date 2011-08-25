package com.iappsam;

public enum AccountType {

	SPSO_PERSONNEL("SPSO Personnel");

	private String name;

	private AccountType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
