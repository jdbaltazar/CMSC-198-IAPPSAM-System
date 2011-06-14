package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public class ViewPRAction implements Action {

	private PRManager prm;

	public ViewPRAction(PRManager prm) {
		this.prm = prm;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);
		try {
			request.setAttribute("form", prm.getPR(id));
			request.getRequestDispatcher(PRServlet.VIEW_PR_JSP).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
