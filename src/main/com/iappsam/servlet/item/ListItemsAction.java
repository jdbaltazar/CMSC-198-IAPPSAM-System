package com.iappsam.servlet.item;

import static com.iappsam.servlet.item.ItemAttribute.ITEMS;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ListItemsAction implements Action {

	private ItemManager itemManager;

	public ListItemsAction(ItemManager itemManager) {
		super();
		this.itemManager = itemManager;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> items;
		try {
			items = itemManager.getAllItems();
			request.setAttribute(ITEMS, items);
			request.getRequestDispatcher(ItemServlet.LIST_ITEMS_JSP).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
