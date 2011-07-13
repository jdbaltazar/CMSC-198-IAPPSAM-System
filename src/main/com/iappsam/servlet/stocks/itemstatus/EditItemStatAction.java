package com.iappsam.servlet.stocks.itemstatus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemStatus;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class EditItemStatAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		System.out.println(".........inside edititemstatus.java");

		int itemStatusID = Integer.parseInt(request.getParameter("itemStatusID"));
		ItemStatus itemStatus = new ItemStatus();
		RequestDispatcher edit = request.getRequestDispatcher(ItemStatusServlet.EDIT_ITEM_STAT);
		try {
			itemStatus = ApplicationContext.INSTANCE.getItemManager().getItemStatus(itemStatusID);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("itemStatus", itemStatus);
		edit.forward(request, response);
	}

}
