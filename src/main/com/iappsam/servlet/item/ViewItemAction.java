package com.iappsam.servlet.item;

import static com.iappsam.servlet.item.ItemParameter.ITEM_ID;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ViewItemAction implements Action {

	private ItemManager itemManager;

	public ViewItemAction(ItemManager itemManager) {
		super();
		this.itemManager = itemManager;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int itemID = Integer.parseInt(request.getParameter(ITEM_ID));
			Item item = itemManager.getItem(itemID);
			request.setAttribute(ItemAttribute.ITEM, item);
			request.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP).forward(request, response);
		} catch (TransactionException e1) {
			e1.printStackTrace();
		}
	}
}
