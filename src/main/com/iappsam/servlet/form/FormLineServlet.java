package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

public class FormLineServlet extends HttpServlet {

	private static final long serialVersionUID = 934187072429086806L;

	private SearchItemAction searchItem;
	private ListItemsAction listItems;
	private AddFormLineAction addFormLine;

	public FormLineServlet(FormUtility utility) {
		this.listItems = new ListItemsAction(utility);
		this.searchItem = new SearchItemAction(utility);
		this.addFormLine = new AddFormLineAction(utility);
	}

	public FormLineServlet(SearchItemAction searchItem, ListItemsAction listItems, AddFormLineAction addFormLine) {
		super();
		this.searchItem = searchItem;
		this.listItems = listItems;
		this.addFormLine = addFormLine;
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
		if (req.getParameter("q") != null&&!req.getParameter("q").trim().equalsIgnoreCase(""))
			return searchItem;
		else if (req.getParameter("add") != null && req.getParameter("add").equals("items"))
			return addFormLine;
		return listItems;
	}

}