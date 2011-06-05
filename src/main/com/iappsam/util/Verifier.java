package com.iappsam.util;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.entities.Account;
import com.iappsam.managers.exceptions.TransactionException;

public class Verifier {

	public static boolean validEntry(String value) {
		if (value == null)
			return false;
		if (value.equalsIgnoreCase(""))
			return false;
		return true;
	}

	public static boolean validUsername(HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("username");
		if (username == null)
			return false;
		if (username.equalsIgnoreCase(""))
			return false;
		if (!Verifier.valid(username))
			return false;
		return true;
	}

	public static boolean valid(String username) {
		Account acc = null;
		try {
			acc = Managers.aManager.getAccount(username);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (acc != null)
			return true;
		return false;

	}

}
