package com.iappsam.auth;

import java.security.Principal;

public class AccountTypePrincipal implements Principal {

	private final String accountType;

	public AccountTypePrincipal(String accountType) {
		if (accountType == null) {
			throw new IllegalArgumentException("Null name");
		}
		this.accountType = accountType;
	}

	@Override
	public String getName() {
		return accountType;
	}

	@Override
	public String toString() {
		return "ExamplePrinciapl: " + accountType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof AccountTypePrincipal))
			return false;
		AccountTypePrincipal another = (AccountTypePrincipal) obj;
		return accountType.equals(another.getName());
	}

	public int hasCode() {
		return accountType.hashCode();
	}
}
