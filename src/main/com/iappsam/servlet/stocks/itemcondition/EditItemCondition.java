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

/**
 * Servlet implementation class EditItemCondition
 */
@WebServlet("/stocks/stocks/EditItemCondition.do")
public class EditItemCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditItemCondition() {
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

		System.out.println("inside edititemcondition.java");

		int itemConditionID = Integer.parseInt((String) request.getParameter("itemConditionID"));
		ItemCondition itemCondition = new ItemCondition();
		RequestDispatcher edit = request.getRequestDispatcher("EditItemCondition.jsp");
		try {
			itemCondition = Managers.ITEM_MANAGER.getItemCondition(itemConditionID);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("itemCondition", itemCondition);
		edit.forward(request, response);
	}

}
