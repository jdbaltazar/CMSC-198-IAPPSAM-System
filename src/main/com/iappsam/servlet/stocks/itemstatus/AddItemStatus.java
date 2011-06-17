package com.iappsam.servlet.stocks.itemstatus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemStatus;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.Verifier;

@WebServlet("/stocks/stocks/AddItemStatus.do")
public class AddItemStatus extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddItemStatus() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ItemManager itemManager = new ItemManagerSession();
		ItemStatus status = new ItemStatus();

		RequestDispatcher add = request.getRequestDispatcher("AddItemStatus.jsp");
		String statusInput = request.getParameter("itemStatus");

		if (Verifier.validEntry(statusInput)) {
			status.setName(statusInput);
			try {
				itemManager.addItemStatus(status);
				add = request.getRequestDispatcher("ViewItemStatuses.do");
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}
		add.forward(request, response);

	}
}
