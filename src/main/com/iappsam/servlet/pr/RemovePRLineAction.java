package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.PR;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public class RemovePRLineAction implements Action {

	private PRParser factory;
	private ApplicationContext appContext;

	public RemovePRLineAction(ApplicationContext appContext, PRParser factory) {
		super();
		this.appContext = appContext;
		this.factory = factory;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String[] indexesToRemove = request.getParameterValues("checkedItems");

			if (indexesToRemove != null) {
				PR pr = (PR) factory.createForm(request, appContext);
				request.getSession().setAttribute("form", pr);
				for (String i : indexesToRemove)
					pr.removeLine(Integer.parseInt(i));
			}
			response.sendRedirect("/pr?new=pr");
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
