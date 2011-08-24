package com.iappsam.util;

public class Validator {

	public static boolean validField(String value) {
		if (value == null)
			return false;
		if (value.trim().equalsIgnoreCase(""))
			return false;
		return true;
	}

}
