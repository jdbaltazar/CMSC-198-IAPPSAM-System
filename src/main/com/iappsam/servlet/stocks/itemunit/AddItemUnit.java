package com.iappsam.servlet.stocks.itemunit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.Verifier;

@WebServlet("/stocks/stocks/AddItemUnit.do")
public class AddItemUnit extends HttpServlet {

	public AddItemUnit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("......inside aaditemunit.java");
		
		ItemManager itemManager = new ItemManagerSession();
		Unit unit = new Unit();

		RequestDispatcher add = request.getRequestDispatcher("AddItemUnit.jsp");
		String unitInput = (String) request.getParameter("unitField");

		if (Verifier.validEntry(unitInput)) {
			unit.setName(unitInput);
			try {
				itemManager.addUnit(unit);
				add = request.getRequestDispatcher("ViewItemUnits.do");
				System.out.println("item unit was saved!!!");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		add.forward(request, response);
		
	}
}
