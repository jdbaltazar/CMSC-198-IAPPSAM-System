package com.iappsam.servlet.stocks.itemunit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Unit;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;
import com.iappsam.util.Verifier;

/**
 * Servlet implementation class SaveEditedItemUnit
 */
@WebServlet("/stocks/stocks/SaveEditedItemUnit.do")
public class SaveEditedItemUnit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEditedItemUnit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("....inside saveediteditemunit.java");

		RequestDispatcher save = request.getRequestDispatcher("EditItemUnit.do");
		int itemUnitID = Integer.parseInt(request.getParameter("itemUnitID"));
		String name = request.getParameter("unitField");

		Unit unit = null;
		try {
			unit = Managers.ITEM_MANAGER.getUnit(itemUnitID);
			if (Verifier.validEntry(name)) {
				unit.setName(name);
				Managers.ITEM_MANAGER.updateUnit(unit);
				save = request.getRequestDispatcher("ViewItemUnits.do");
			} else {
				request.setAttribute("itemUnit", unit);
			}
		} catch (TransactionException e) {
			e.printStackTrace();
			request.setAttribute("itemUnit", unit);
		}
		save.forward(request, response);
	}

}
