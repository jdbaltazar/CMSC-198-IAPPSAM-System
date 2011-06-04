package com.iappsam.servlet.stocks.itemunit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.Unit;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class EditItemUnit
 */
@WebServlet("/stocks/stocks/EditItemUnit.do")
public class EditItemUnit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditItemUnit() {
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

		System.out.println("inside edititemunit.java");

		int itemUnitID = Integer.parseInt((String) request.getParameter("itemUnitID"));
		Unit unit = new Unit();
		RequestDispatcher edit = request.getRequestDispatcher("EditItemUnit.jsp");
		try {
			unit = ManagerBin.iManager.getUnit(itemUnitID);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("itemUnit", unit);
		edit.forward(request, response);
	}

}
