package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.PR;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public class PRLinePageAction implements Action {

	private PRParser factory;
	private ApplicationContext appContext;

	public PRLinePageAction(ApplicationContext appContext, PRParser factory) {
		super();
		this.appContext = appContext;
		this.factory = factory;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PR pr = (PR) factory.createForm(request, appContext);
			request.getSession().setAttribute("form", pr);
			response.sendRedirect("/pr/line");
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
