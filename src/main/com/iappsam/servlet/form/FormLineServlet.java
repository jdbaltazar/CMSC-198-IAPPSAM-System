package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.item.Action;
import com.iappsam.servlet.pr.AddPRLineAction;
import com.iappsam.servlet.pr.PRListItemsAction;
import com.iappsam.servlet.pr.PRSearchItemAction;

public abstract class FormLineServlet extends HttpServlet {

	private SearchItemAction searchItem;
	private ListItemsAction listItems;
	private AddFormLineAction addSelectedItems;

	public FormLineServlet(PRListItemsAction listItems, PRSearchItemAction searchItem, AddPRLineAction addSelectedItemAction) {
		this.listItems = listItems;
		this.searchItem = searchItem;
		this.addSelectedItems = addSelectedItemAction;
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		parseAction(req).process(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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