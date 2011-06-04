package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

@WebServlet("/items")
public class ItemServlet extends HttpServlet {
	public static final String SEARCH_ITEMS_JSP = "/items/SearchItems.jsp";
	private static final long serialVersionUID = 1L;

	public ItemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ItemAction action = getAction(request);

		if (action == ItemAction.VIEW_ITEMS) {
			viewItem(request, response);
		}
	}

	private void viewItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Item> items = new ArrayList<Item>();
		try {
			items = ManagerBin.iManager.getAllItems();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		request.setAttribute("items", items);
		request.getRequestDispatcher(SEARCH_ITEMS_JSP).forward(request, response);
	}

	private ItemAction getAction(HttpServletRequest request) {
		if (request.getParameter("view").equals("items"))
			return ItemAction.VIEW_ITEMS;
		else
			return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
