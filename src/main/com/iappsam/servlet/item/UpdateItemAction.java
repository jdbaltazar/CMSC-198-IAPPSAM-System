package com.iappsam.servlet.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.ItemManager;
import com.iappsam.servlet.Action;

public class UpdateItemAction implements Action {

	private ItemManager im;

	public UpdateItemAction(ItemManager itemManager) {
		im = itemManager;
	}

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP).forward(req, res);
	}

}
