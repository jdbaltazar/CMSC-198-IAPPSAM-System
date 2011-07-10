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
import com.iappsam.util.Validator;

public class SaveEditedItemStatAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		System.out.println(".......inside saveediteditemstatus");

		// RequestDispatcher save =
		// request.getRequestDispatcher("EditItemStatus.do");
		Action action = new EditItemStatAction();

		int itemStatusID = Integer.parseInt(request.getParameter("itemStatusID"));
		String name = request.getParameter("itemStatus").trim();

		ItemStatus itemStatus = null;

		try {
			itemStatus = ApplicationContext.INSTANCE.getItemManager().getItemStatus(itemStatusID);
			if (Validator.validField(name)) {
				itemStatus.setName(name);
				ApplicationContext.INSTANCE.getItemManager().updateItemStatus(itemStatus);
				Action vAction = new ViewItemStatsAction();
				vAction.process(request, response);
				return;
			}
		} catch (TransactionException e) {
			e.printStackTrace();
			request.setAttribute("itemStatus", itemStatus);
		}
		request.setAttribute("itemStatusID", "" + itemStatusID);
		action.process(request, response);
	}

}
