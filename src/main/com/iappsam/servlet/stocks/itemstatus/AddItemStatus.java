package com.iappsam.servlet.stocks.itemstatus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemStatus;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.Verifier;

@WebServlet("/stocks/stocks/AddItemStatus.do")
public class AddItemStatus extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddItemStatus() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		ItemStatus status = new ItemStatus();

		RequestDispatcher add = request.getRequestDispatcher("AddItemStatus.jsp");
		String statusInput = (String) request.getParameter("statusField");

		if (Verifier.validEntry(statusInput)) {
			status.setName(statusInput);
			try {
				itemManager.addItemStatus(status);
				add = request.getRequestDispatcher("ViewItemStatuses.do");
				System.out.println("status was saved!!!!!!!");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}

		add.forward(request, response);

	}
}
