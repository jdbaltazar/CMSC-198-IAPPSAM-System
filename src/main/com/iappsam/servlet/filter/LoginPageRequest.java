package com.iappsam.servlet.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.LoginModule;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Verifier;

public class LoginPageRequest implements Request {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException,
			TransactionException {

		String username = (String) request.getSession().getAttribute("username");
		if (username == null) // {
			chain.doFilter(request, response);
		// } else {
		//
		// if (Verifier.validEntry(username)) {
		// // login here
		// LoginModule loginModule = new LoginModule();
		// if (loginModule.login(request)) {
		// response.sendRedirect("/menu");
		// return;
		// }
		// }
		// chain.doFilter(request, response);
		//
		// }

	}

}
