package com.iappsam;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import com.iappsam.auth.WebCallbackHandler;
import com.iappsam.entities.Account;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;

public class LoginModule {

	private LoginContext lContext = null;
	private AccountManager am;

	public LoginModule() {
		super();
		am = new AccountManagerSession();
	}

	public boolean login(HttpServletRequest request) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			if (username.isEmpty() || password.isEmpty())
				return false;
			Account account = am.getAccount(username);
			if (account != null) {
				boolean valid = account.comparePassword(password);
				if (valid) {
					// try {
					// lContext = new LoginContext("WebCallbackHandler", new
					// WebCallbackHandler(request));
					// lContext.login();
					// request.getSession().setAttribute("loginContext", lContext);
					request.getSession().setAttribute("username", username);
					return true;
					// } catch (LoginException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
				}
			}
		} catch (TransactionException e) {
			return false;
		}
		return false;
	}
}
