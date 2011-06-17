package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public abstract class ViewFormAction implements Action {

	public ViewFormAction() {
		super();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		try {
			int id = Integer.parseInt(idParam);
			Form form = getForm(id);
			if (form == null) {
				response.sendRedirect(getFormListLink());
				return;
			}
			request.setAttribute("form", form);
			request.getRequestDispatcher(getViewFormJsp()).forward(request, response);
		} catch (Exception e) {
			response.sendRedirect(getFormListLink());
			return;
		}
	}

	protected abstract Form getForm(Object id) throws TransactionException;

	protected abstract String getViewFormJsp();

	protected abstract String getFormListLink();

}