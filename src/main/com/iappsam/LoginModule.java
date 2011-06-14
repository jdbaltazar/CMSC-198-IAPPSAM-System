package com.iappsam;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;

import com.iappsam.auth.WebCallbackHandler;
import com.iappsam.entities.Account;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;

public class LoginModule {

	private WebCallbackHandler webcallback;
	private LoginContext lcontext = null;
	private AccountManager am;

	public LoginModule() {
		super();
		am = new AccountManagerSession();
	}

	public boolean login(HttpServletRequest request) {

		String username = request.getParameter("USERNAME");
		String password = request.getParameter("PASSWORD");

		try {
			if (username.isEmpty() || password.isEmpty())
				return false;
			Account account = am.getAccount(username);
			if (account != null)
				return account.comparePassword(password);
		} catch (TransactionException e) {
			return false;
		}
		return false;
	}
}
