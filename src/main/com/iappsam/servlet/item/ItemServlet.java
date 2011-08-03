package com.iappsam.servlet.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

@WebServlet("/items")
public class ItemServlet extends HttpServlet {

	public static final String LIST_ITEMS_JSP = "/items/list-items.jsp";
	public static final String NEW_ITEM_JSP = "/items/new-item.jsp";
	public static final String VIEW_ITEM_JSP = "/items/view-item.jsp";

	private static final long serialVersionUID = 1L;

	private AddItemAction addItem;
	private NewItemAction newItem;
	private ViewItemAction viewItem;
	private SearchItemsAction searchItems;
	private ListItemsAction listItems;
	private UpdateItemAction updateItem;

	public ItemServlet() {
		this(ApplicationContext.INSTANCE);
	}

	public ItemServlet(ApplicationContext m) {
		super();
		addItem = new AddItemAction(m.getItemManager());
		newItem = new NewItemAction(m.getItemManager());
		viewItem = new ViewItemAction(m.getItemManager());
		listItems = new ListItemsAction(m.getItemManager());
		updateItem = new UpdateItemAction(m.getItemManager());
		searchItems = new SearchItemsAction(m.getItemSearcher());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parseAction(request).process(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parseAction(request).process(request, response);
	}

	private Action parseAction(HttpServletRequest request) {

		String newParam = request.getParameter(ItemParameter.NEW_ITEM);
		String id = request.getParameter("id");
		String q = request.getParameter(ItemParameter.QUERY);
		String add = request.getParameter("add");
		String update = request.getParameter("update");

		if (newParam != null && newParam.equals("item"))
			return newItem;
		else if (add != null && add.equals("item"))
			return addItem;
		else if (update != null && update.equals("item"))
			return updateItem;
		else if (id != null)
			return viewItem;
		else if (q != null)
			return searchItems;
		return listItems;
	}

}
