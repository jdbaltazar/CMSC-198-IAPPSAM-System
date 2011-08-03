package com.iappsam.servlet.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.testing.cache.Item;

import com.iappsam.managers.ItemManager;
import com.iappsam.servlet.Action;

public class UpdateItemAction implements Action {

	private ItemManager im;

	public UpdateItemAction(ItemManager itemManager) {
		im = itemManager;
	}

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Item item = new Item();
		
		String idParam = req.getParameter("id");
		String description = req.getParameter("description");
		String stockNumber = req.getParameter("stockNumber");
		String unit = req.getParameter("unit");
		String price = req.getParameter("price");
		String date = req.getParameter("date");
		String inventoryItemNumber = req.getParameter("inventoryItemNum");
		String propertyNumber = req.getParameter("propertyNumber");
		String statusName = req.getParameter("itemStatus");
		String conditionName = req.getParameter("itemCondition");
		String categoryName = req.getParameter("itemCategory");
		
		req.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP).forward(req, res);
	}

}
