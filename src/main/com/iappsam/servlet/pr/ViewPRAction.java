package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.PR;
import com.iappsam.managers.PRManager;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public class ViewPRAction implements Action {

	private PRManager prm;

	public ViewPRAction(ApplicationContext m) {
		this.prm = m.getPRManager();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		try {
			int id = Integer.parseInt(idParam);
			PR pr = prm.getPR(id);
			if (pr == null)
				response.sendRedirect("/pr");
			request.setAttribute("form", pr);
			request.getRequestDispatcher(PRServlet.VIEW_PR_JSP).forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/pr");
		}
	}
}
