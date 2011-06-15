package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.forms.Form;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public class AddSelectedItemAction implements Action {

	private ItemManager im;

	public AddSelectedItemAction(ItemManager im) {
		super();
		this.im = im;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("itemIds");
		Form form = (Form) request.getSession().getAttribute("form");

		for (String id : ids)
			try {
				Item item = im.getItem(Integer.parseInt(id));
				form.addItem(item);
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		response.sendRedirect("/pr?new=pr");
	}
}
