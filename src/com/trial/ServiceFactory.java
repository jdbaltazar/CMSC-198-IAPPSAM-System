package com.trial;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceFactory {

	public static PersonManager createPersonManager() {
		return create(PersonManager.class);
	}

	@SuppressWarnings("unchecked")
	private static <T> T create(Class<T> cl) {
		try {
			Context context = new InitialContext();
			String simpleName = cl.getSimpleName();
			return (T) context.lookup("Trial/" + simpleName + "/remote");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new NullPointerException();
		}
	}
}
