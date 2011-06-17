package com.iappsam.servlet.stocks.itemcondition;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemCondition;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.Verifier;

@WebServlet("/stocks/stocks/AddItemCondition.do")
public class AddItemCondition extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddItemCondition() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ItemManager itemManager = new ItemManagerSession();
		ItemCondition condition = new ItemCondition();

		RequestDispatcher add = request.getRequestDispatcher("AddItemCondition.jsp");

		String conditionInput = request.getParameter("itemCondition");

		if (Verifier.validEntry(conditionInput)) {
			condition.setName(conditionInput);
			try {
				itemManager.addItemCondition(condition);
				add = request.getRequestDispatcher("ViewItemConditions.do");
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}
		add.forward(request, response);
	}
}
