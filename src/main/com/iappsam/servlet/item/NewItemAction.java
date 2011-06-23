package com.iappsam.servlet.item;

import static com.iappsam.servlet.item.ItemAttribute.CATEGORIES;
import static com.iappsam.servlet.item.ItemAttribute.CONDITIONS;
import static com.iappsam.servlet.item.ItemAttribute.DONE;
import static com.iappsam.servlet.item.ItemAttribute.STATUSES;
import static com.iappsam.servlet.item.ItemAttribute.UNITS;
import static com.iappsam.servlet.item.ItemAttribute.VALID_INPUT_FOR_ITEM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.ItemManager;

public class NewItemAction implements Action {

	private ItemManager itemManager;

	public NewItemAction(ItemManager itemManager) {
		super();
		this.itemManager = itemManager;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute(UNITS, itemManager.getAllUnits());
			request.setAttribute(CATEGORIES, itemManager.getAllItemCategory());
			request.setAttribute(STATUSES, itemManager.getAllItemStatus());
			request.setAttribute(CONDITIONS, itemManager.getAllItemCondition());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(ItemServlet.NEW_ITEM_JSP).forward(request, response);
	}
}
