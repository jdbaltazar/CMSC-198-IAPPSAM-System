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

public class AddFormLineAction implements Action {

	private ItemManager im;
	private String formName;

	public AddFormLineAction(FormUtility utility) {
		im = utility.getApplicationContext().getItemManager();
		this.formName = utility.getFormName();
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
			response.sendRedirect(getNewFormLink());
		} else
			response.sendRedirect(getAddLineLink());
	}

	protected String getAddLineLink() {
		return String.format("/%s/line", formName);
	}

	protected String getNewFormLink() {
		return String.format("/%s?new=%s", formName, formName);
	}
}