package com.iappsam.servlet.stocks.itemstatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemStatus;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.servlet.Action;

public class ViewItemStatsAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		RequestDispatcher view = request.getRequestDispatcher(ItemStatusServlet.VIEW_ITEM_STATS);

		List<ItemStatus> statuses = new ArrayList<ItemStatus>();

		try {
			statuses = itemManager.getAllItemStatus();
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("itemStatuses", statuses);

		view.forward(request, response);
	}
}
