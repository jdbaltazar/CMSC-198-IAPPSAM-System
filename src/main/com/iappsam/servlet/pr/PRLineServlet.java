package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.item.Action;
import com.iappsam.util.Managers;

@WebServlet("/pr/line")
public class PRLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String LIST_ITEMS = "/pr/line/add-item.jsp";
	private PRSearchItemAction searchItem;
	private PRListItemsAction listItems;
	private AddSelectedItemAction addSelectedItems;

	public PRLineServlet() {
		this(new PRListItemsAction(Managers.INSTANCE.getItemManager()), new PRSearchItemAction(Searchers.ITEM_SEARCHER), new AddSelectedItemAction(Managers.INSTANCE.getItemManager()));
	}

	public PRLineServlet(PRListItemsAction listItems, PRSearchItemAction searchItem, AddSelectedItemAction addSelectedItemAction) {
		this.listItems = listItems;
		this.searchItem = searchItem;
		this.addSelectedItems = addSelectedItemAction;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		parseAction(req).process(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		parseAction(req).process(req, resp);
	}

	private Action parseAction(HttpServletRequest req) {
		if (req.getParameter("q") != null)
			return searchItem;
		else if (req.getParameter("add") != null && req.getParameter("add").equals("items"))
			return addSelectedItems;
		return listItems;
	}
}
