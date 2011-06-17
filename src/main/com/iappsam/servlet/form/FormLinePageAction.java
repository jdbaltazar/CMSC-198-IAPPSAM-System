package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public class FormLinePageAction implements Action {
	private FormParser factory;
	private ApplicationContext appContext;
	private String formName;

	public FormLinePageAction(FormUtility utility) {
		this.appContext = utility.getApplicationContext();
		this.factory = utility.getParser();
		this.formName = utility.getFormName();
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

	public String getFormLineLink() {
		return String.format("/%s/line", formName);
	}

}