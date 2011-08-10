package com.iappsam.servlet.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FailAccountForExistingEmployeeAction {
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(AccountServlet.CREATE_ACCOUNT_FOR_EXISTING).forward(request, response);
		
	}
}
