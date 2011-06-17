package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Form;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public abstract class RemoveFormLineAction implements Action {

	private FormParser factory;
	private ApplicationContext appContext;
	private ItemManager im;

	public RemoveFormLineAction(ApplicationContext appContext, FormParser factory) {
		this.appContext = appContext;
		this.factory = factory;
		this.im = appContext.getItemManager();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String[] indexesToRemove = request.getParameterValues("checkedItems");

			if (indexesToRemove != null) {
				Form form = factory.createForm(request, appContext);
				request.getSession().setAttribute("form", form);
				for (String i : indexesToRemove)
					form.removeItem(im.getItem(Integer.parseInt(i)));
			}
			response.sendRedirect(getNewFormLink());
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	protected abstract String getNewFormLink();

}