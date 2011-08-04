package com.iappsam.auth;

import java.util.*;
import java.security.Principal;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.login.LoginException;

public class WebLoginModule implements LoginModule {
	private Subject subject;
	private Principal accountType;
	private CallbackHandler callbackhandler;
	private static final int NOT = 0;
	private static final int OK = 1;
	private static final int COMMIT = 2;
	private int status;

	@Override
	public void initialize(Subject subject, CallbackHandler//
			callbackhandler, Map state, Map options) {
		status = NOT;
		accountType = null;
		this.subject = subject;
		this.callbackhandler = callbackhandler;
	}

	@Override
	public boolean login() throws LoginException {

		if (callbackhandler == null) {
			throw new LoginException("No callback handler is available");
		}
		Callback callbacks[] = new Callback[1];
		callbacks[0] = new NameCallback("What is the weather like today?");
		String name = null;
		try {
			callbackhandler.handle(callbacks);
			name = ((NameCallback) callbacks[0]).getName();
		} catch (java.io.IOException ioe) {
			throw new LoginException(ioe.toString());
		} catch (UnsupportedCallbackException ce) {
			throw new LoginException("Error: " + ce.getCallback().toString());
		}
		if (name.equals("Sunny")) {
			accountType = new AccountTypePrincipal("SunnyDay");
			status = OK;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean commit() throws LoginException {
		if (status == NOT) {
			return false;
		}
		if (subject == null) {
			return false;
		}
		Set entities = subject.getPrincipals();
		if (!entities.contains(accountType)) {
			entities.add(accountType);
		}
		status = COMMIT;
		return true;
	}

	@Override
	public boolean abort() throws LoginException {
		if ((subject != null) && (accountType != null)) {
			Set entities = subject.getPrincipals();
			if (entities.contains(accountType)) {
				entities.remove(accountType);
			}
		}
		subject = null;
		accountType = null;
		status = NOT;
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		subject.getPrincipals().remove(accountType);
		status = NOT;
		subject = null;
		return true;
	}
}