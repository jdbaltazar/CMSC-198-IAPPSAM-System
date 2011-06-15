package com.iappsam.servlet.stocks.itemunit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Unit;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ApplicationContext;

@WebServlet("/stocks/stocks/EditItemUnit.do")
public class EditItemUnit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditItemUnit() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("inside edititemunit.java");

		int itemUnitID = Integer.parseInt(request.getParameter("itemUnitID"));
		Unit unit = new Unit();
		RequestDispatcher edit = request.getRequestDispatcher("EditItemUnit.jsp");
		try {
			unit = ApplicationContext.INSTANCE.getItemManager().getUnit(itemUnitID);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("itemUnit", unit);
		edit.forward(request, response);
	}

}
