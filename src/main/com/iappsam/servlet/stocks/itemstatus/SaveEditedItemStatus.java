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
import com.iappsam.util.ManagerBin;
import com.iappsam.util.Verifier;

/**
 * Servlet implementation class SaveEditedItemStatus
 */
@WebServlet("/stocks/stocks/SaveEditedItemStatus.do")
public class SaveEditedItemStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEditedItemStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println(".......inside saveediteditemstatus");

		RequestDispatcher save = request.getRequestDispatcher("EditItemStatus.do");
		int itemStatusID = Integer.parseInt((String) request.getParameter("itemStatusID"));
		String name = (String) request.getParameter("statusField");

		ItemStatus itemStatus = null;

		try {
			itemStatus = ManagerBin.iManager.getItemStatus(itemStatusID);
			if (Verifier.validEntry(name)) {
				itemStatus.setName(name);
				ManagerBin.iManager.updateItemStatus(itemStatus);
				save = request.getRequestDispatcher("ViewItemStatuses.do");
			} else {
				request.setAttribute("itemStatus", itemStatus);
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("itemStatus", itemStatus);
		}

		save.forward(request, response);
	}

}
