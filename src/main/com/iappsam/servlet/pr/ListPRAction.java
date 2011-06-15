package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public class ListPRAction implements Action {

	private PRManager prm;

	public ListPRAction(ApplicationContext m) {
		super();
		this.prm = m.getPRManager();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("PRs", prm.getAllPR());
			request.getRequestDispatcher(PRServlet.LIST_PR_JSP).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
