package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.forms.Form;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public abstract class AddLineAction implements Action {

	private ItemManager im;

	public AddLineAction(ApplicationContext appContext) {
		im = appContext.getItemManager();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("itemIds");
		Form form = (Form) request.getSession().getAttribute("form");

		if (ids != null) {
			for (String id : ids)
				try {
					Item item = im.getItem(Integer.parseInt(id));
					form.addItem(item);
				} catch (TransactionException e) {
					e.printStackTrace();
				}
			response.sendRedirect(newFormPage());
		} else
			response.sendRedirect(addLinePage());
	}

	protected abstract String addLinePage();

	protected abstract String newFormPage();
}