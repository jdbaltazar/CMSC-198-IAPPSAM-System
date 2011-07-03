package com.iappsam.util;

import javax.servlet.http.HttpServletRequest;

public class Validator {

	public static boolean validField(String value) {
		if (value == null)
			return false;
		if (value.trim().equalsIgnoreCase(""))
			return false;
		return true;
	}

	public static boolean validUsername(HttpServletRequest request) {

		String username = (String) request.getSession().getAttribute("username");
		if (username == null)
			return false;
		if (username.equalsIgnoreCase(""))
			return false;
		return true;
	}
}
