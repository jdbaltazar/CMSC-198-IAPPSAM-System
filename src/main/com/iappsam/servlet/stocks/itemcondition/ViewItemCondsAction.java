package com.iappsam.servlet.stocks.itemcondition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemCondition;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.servlet.Action;

public class ViewItemCondsAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		RequestDispatcher view = request.getRequestDispatcher(ItemConditionServlet.VIEW_ITEM_CONDS);
		
		List<ItemCondition> itemConditions = new ArrayList<ItemCondition>();
		
		try {
			itemConditions = itemManager.getAllItemCondition();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("itemConditions", itemConditions);
		
		view.forward(request, response);
	}

}
