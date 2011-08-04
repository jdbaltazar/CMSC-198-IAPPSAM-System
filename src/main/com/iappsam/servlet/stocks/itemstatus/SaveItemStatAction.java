package com.iappsam.servlet.stocks.itemstatus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemStatus;
import com.iappsam.logging.Logger;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveItemStatAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		ItemStatus status = new ItemStatus();

		RequestDispatcher add = request.getRequestDispatcher(ItemStatusServlet.ADD_ITEM_STAT);
		String statusInput = request.getParameter("itemStatus").trim();

		if (Validator.validField(statusInput)) {
			status.setName(statusInput);
			try {
				itemManager.addItemStatus(status);
				Logger.log(request, "Status \""+statusInput+"\" was added");
				Action viewAction = new ViewItemStatsAction();
				viewAction.process(request, response);
				return;
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}
		add.forward(request, response);
	}

}
