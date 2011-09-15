package com.iappsam.servlet.item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;

public class UpdateItemAction extends AddItemAction {

	public UpdateItemAction(ItemManager itemManager) {
		super(itemManager);
	}

	@Override
	protected void forward(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP);
		dispatcher.forward(req, response);
	}

	@Override
	protected Item getItem(HttpServletRequest req, HttpServletResponse res) {
		try {
			return getItemManager().getItem(req.getParameter("id"));
		} catch (TransactionException e) {
		}
		return new Item();
	}
}
