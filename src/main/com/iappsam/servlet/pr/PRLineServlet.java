package com.iappsam.servlet.pr;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormLineServlet;
import com.iappsam.util.ApplicationContext;

@WebServlet("/pr/line")
public class PRLineServlet extends FormLineServlet {
	private static final long serialVersionUID = 1L;
	public static final String LIST_ITEMS_JSP = "/pr/line/add-item.jsp";

	public PRLineServlet() {
		this(new PRListItemsAction(ApplicationContext.INSTANCE), //
				new PRSearchItemAction(ApplicationContext.INSTANCE), //
				new AddPRLineAction(ApplicationContext.INSTANCE));
	}

	public PRLineServlet(PRListItemsAction listItems, PRSearchItemAction searchItem, AddPRLineAction addSelectedItemAction) {
		super(listItems, searchItem, addSelectedItemAction);
	}
}
