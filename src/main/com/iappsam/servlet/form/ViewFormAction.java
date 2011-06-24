package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public class ViewFormAction implements Action {

	private String formName;
	private FormUtility utility;

	public ViewFormAction(FormUtility utility) {
		super();
		this.formName = utility.getFormName();
		this.utility = utility;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		try {
			int id = Integer.parseInt(idParam);
			Form form = utility.getForm(id);
			if (form == null) {
				response.sendRedirect(getFormListLink());
				return;
			}
			request.getSession().setAttribute("form", form);
			request.getRequestDispatcher(getViewFormJsp()).forward(request, response);
		} catch (Exception e) {
			response.sendRedirect(getFormListLink());
			return;
		}
	}

	protected String getViewFormJsp() {
		return String.format("/%s/view-%s.jsp", formName, formName);
	}

	protected String getFormListLink() {
		return "/" + formName;
	}
}