package com.iappsam.servlet.stocks.itemstatus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemStatus;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;
import com.iappsam.util.Verifier;

@WebServlet("/stocks/stocks/SaveEditedItemStatus.do")
public class SaveEditedItemStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveEditedItemStatus() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(".......inside saveediteditemstatus");

		RequestDispatcher save = request.getRequestDispatcher("EditItemStatus.do");
		int itemStatusID = Integer.parseInt(request.getParameter("itemStatusID"));
		String name = request.getParameter("statusField");

		ItemStatus itemStatus = null;

		try {
			itemStatus = Managers.ITEM_MANAGER.getItemStatus(itemStatusID);
			if (Verifier.validEntry(name)) {
				itemStatus.setName(name);
				Managers.ITEM_MANAGER.updateItemStatus(itemStatus);
				save = request.getRequestDispatcher("ViewItemStatuses.do");
			} else {
				request.setAttribute("itemStatus", itemStatus);
			}
		} catch (TransactionException e) {
			e.printStackTrace();
			request.setAttribute("itemStatus", itemStatus);
		}
		save.forward(request, response);
	}
}
