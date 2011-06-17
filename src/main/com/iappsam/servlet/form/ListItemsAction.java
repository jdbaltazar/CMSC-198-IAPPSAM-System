package com.iappsam.servlet.form;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.forms.Form;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public abstract class ListItemsAction implements Action {
	private ItemManager im;

	public ListItemsAction(ApplicationContext appContext) {
		this.im = appContext.getItemManager();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Form form = (Form) request.getSession().getAttribute("form");
			if (form == null) {
				response.sendRedirect("/menu");
				return;
			}
			List<Item> items = im.getAllItems();
			items.removeAll(form.getItems());
			request.setAttribute("items", items);
			request.getRequestDispatcher(getListItemJsp()).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	protected abstract String getListItemJsp();
}