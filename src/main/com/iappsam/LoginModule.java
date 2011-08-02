package com.iappsam;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.managers.AccountManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;

public class LoginModule {

	private AccountManager am;

	public LoginModule() {
		super();
		am = new AccountManagerSession();
	}

	public boolean login(HttpServletRequest request) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			if (username == null || password == null || username.isEmpty() || password.isEmpty())
				return false;
			Account account = am.getAccount(username);
			if (account != null) {
				boolean valid = account.comparePassword(password);
				if (valid) {
					request.getSession().setAttribute("account", account);
					return true;
				}
			}
		} catch (TransactionException e) {
			return false;
		}
		return false;
	}
}
