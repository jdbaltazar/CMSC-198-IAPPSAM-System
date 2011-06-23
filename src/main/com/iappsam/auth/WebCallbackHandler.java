package com.iappsam.auth;

import javax.security.auth.callback.*;
import javax.servlet.ServletRequest;

public class WebCallbackHandler implements CallbackHandler {

	private String username;
	private String password;

	public WebCallbackHandler(ServletRequest request) {
		username = request.getParameter("username");
		password = request.getParameter("password");
	}

	@Override
	public void handle(Callback[] callbacks) throws java.io.IOException, UnsupportedCallbackException {

		// Add the username and password from the request parameters to
		// the Callbacks
		for (int i = 0; i < callbacks.length; i++) {

			if (callbacks[i] instanceof NameCallback) {

				NameCallback nameCall = (NameCallback) callbacks[i];

				nameCall.setName(username);

			} else if (callbacks[i] instanceof PasswordCallback) {

				PasswordCallback passCall = (PasswordCallback) callbacks[i];

				passCall.setPassword(password.toCharArray());

			} else {

				throw new UnsupportedCallbackException(callbacks[i], "The CallBacks are unrecognized in class: " + getClass().getName());

			}

		} // for
	} // handle

}