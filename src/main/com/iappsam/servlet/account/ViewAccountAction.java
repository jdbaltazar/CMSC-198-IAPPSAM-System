package com.iappsam.servlet.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

public class ViewAccountAction implements Action{

	public ViewAccountAction() {
		super();
	}

	public void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher(AccountServlet.VIEW_ACCOUNT).forward(request, response);
	}

}
