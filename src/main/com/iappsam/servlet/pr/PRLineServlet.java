package com.iappsam.servlet.pr;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.AddFormLineAction;
import com.iappsam.servlet.form.FormLineServlet;
import com.iappsam.servlet.form.ListItemsAction;
import com.iappsam.servlet.form.SearchItemAction;
import com.iappsam.util.ApplicationContext;

@WebServlet("/pr/line")
public class PRLineServlet extends FormLineServlet {
	private static final long serialVersionUID = 1L;
	public static final String LIST_ITEMS_JSP = "/pr/line/add-item.jsp";

	public PRLineServlet() {
		this(new ListItemsAction("pr", ApplicationContext.INSTANCE), //
				new SearchItemAction("pr", ApplicationContext.INSTANCE), //
				new AddFormLineAction("pr", ApplicationContext.INSTANCE));
	}

	public PRLineServlet(ListItemsAction listItems, SearchItemAction searchItem, AddFormLineAction addSelectedItemAction) {
		super(listItems, searchItem, addSelectedItemAction);
	}
}
