package com.iappsam.servlet.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;

public class OtherPagesRequest implements Request {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException, TransactionException {
		String username = (String) request.getSession().getAttribute("username");
		if (username != null) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect("/");
		}
	}

}
