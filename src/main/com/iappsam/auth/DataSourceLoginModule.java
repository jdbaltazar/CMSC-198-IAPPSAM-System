package com.iappsam.auth;

import java.util.Map;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.*;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;

import javax.sql.*;

public class DataSourceLoginModule implements LoginModule {

	// These instance variables will be initialized by the
	// initialize( ) method
	private CallbackHandler handler;
	private Subject subject;
	private Map sharedState;
	private Map options;

	private boolean loginPassed = false;

	public DataSourceLoginModule() {
	}// no-arguments constructor

	@Override
	public void initialize(Subject subject, CallbackHandler handler, Map sharedState, Map options) {
		this.subject = subject;
		this.handler = handler;
		this.sharedState = sharedState;
		this.options = options;
	}

	@Override
	public boolean login() throws LoginException {

		String name = "";
		String pass = "";

		Context env = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DataSource pool = null;

		boolean passed = false;

		try {

			// Create the CallBack array to pass to the
			// CallbackHandler.handle( ) method
			Callback[] callbacks = new Callback[2];

			// Don't use null arguments with the NameCallback constructor!
			callbacks[0] = new NameCallback("Username:");

			// Don't use null arguments with PasswordCallback!
			callbacks[1] = new PasswordCallback("Password:", false);

			handler.handle(callbacks);

			// Get the username and password from the CallBacks
			NameCallback nameCall = (NameCallback) callbacks[0];

			name = nameCall.getName();

			PasswordCallback passCall = (PasswordCallback) callbacks[1];

			pass = new String(passCall.getPassword());

			// Look up our DataSource so that we can check the username and
			// password
			env = (Context) new InitialContext().lookup("java:comp/env");

			pool = (DataSource) env.lookup("jdbc/oracle-8i-athletes");

			if (pool == null)
				throw new LoginException("Initializing the DataSource failed.");

			// The SQL for checking a name and password in a table named
			// athlete
			String sql = "select * from athlete where name='" + name + "'";

			String sqlpass = "select * from athlete where passwrd='" + pass + "'";

			// Get a Connection from the connection pool
			conn = pool.getConnection();

			stmt = conn.createStatement();

			// Check the username
			rs = stmt.executeQuery(sql);

			// If the ResultSet has rows, then the username was
			// correct and next( ) returns true
			passed = rs.next();

			rs.close();

			if (!passed) {

				loginPassed = false;
				throw new FailedLoginException("The username was not successfully authenticated");

			}

			// Check the password
			rs = stmt.executeQuery(sqlpass);

			passed = rs.next();

			if (!passed) {

				loginPassed = false;
				throw new FailedLoginException("The password was not successfully authenticated");

			} else {

				loginPassed = true;
				return true;

			}

		} catch (Exception e) {

			throw new LoginException(e.getMessage());

		} finally {

			try {

				// close the Statement
				stmt.close();

				// Return the Connection to the pool
				conn.close();

			} catch (SQLException sqle) {
			}

		} // finally

	} // login

	@Override
	public boolean commit() throws LoginException {

		// We're not doing anything special here, since this class
		// represents a simple example of login authentication with JAAS.
		// Just return what login( ) returned.
		return loginPassed;
	}

	@Override
	public boolean abort() throws LoginException {

		// Reset state
		boolean bool = loginPassed;
		loginPassed = false;

		return bool;
	}

	@Override
	public boolean logout() throws LoginException {

		// Reset state
		loginPassed = false;
		return true;

	} // logout

} // DataSourceLoginModule