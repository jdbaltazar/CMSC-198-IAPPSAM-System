package com.iappsam.servlet.item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.ItemManager;

public class UpdateItemAction extends AddItemAction {

	public UpdateItemAction(ItemManager itemManager) {
		super(itemManager);
	}

	@Override
	protected void forward(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP);
		dispatcher.forward(req, response);
	}
}
