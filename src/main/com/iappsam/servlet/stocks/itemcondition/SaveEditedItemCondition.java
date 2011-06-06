package com.iappsam.servlet.stocks.itemcondition;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCondition;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;
import com.iappsam.util.Verifier;

/**
 * Servlet implementation class SaveEditedItemCondition
 */
@WebServlet("/stocks/stocks/SaveEditedItemCondition.do")
public class SaveEditedItemCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEditedItemCondition() {
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

		System.out.println("inside saveediteditemcondition.java");

		RequestDispatcher save = request.getRequestDispatcher("EditItemCondition.do");
		int itemConditionID = Integer.parseInt((String) request.getParameter("itemConditionID"));
		String name = (String) request.getParameter("conditionField");

		ItemCondition itemCondition = null;

		try {
			itemCondition = Managers.ITEM_MANAGER.getItemCondition(itemConditionID);
			if (Verifier.validEntry(name)) {
				itemCondition.setName(name);
				Managers.ITEM_MANAGER.updateItemCondition(itemCondition);
				save = request.getRequestDispatcher("ViewItemConditions.do");
			} else {
				request.setAttribute("itemCondition", itemCondition);
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("itemCondition", itemCondition);
		}

		save.forward(request, response);
	}

}