package com.iappsam;

import com.iappsam.entities.Account;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;

public class LoginModule {

	public boolean login(String username, String password) {
		AccountManager aManager = new AccountManagerSession();
		try {
			if (username.isEmpty() || password.isEmpty())
				return false;
			Account account = aManager.getAccount(username);
			if (account != null)
				return account.comparePassword(password);
		} catch (TransactionException e) {
			return false;
		}
		return false;
	}
}
