package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public abstract class FormLinePageAction implements Action {
	private FormParser factory;
	private ApplicationContext appContext;

	public FormLinePageAction(ApplicationContext appContext, FormParser factory) {
		this.appContext = appContext;
		this.factory = factory;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Form form = factory.createForm(request, appContext);
			request.getSession().setAttribute("form", form);
			response.sendRedirect(getFormLineLink());
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	public abstract String getFormLineLink();
}