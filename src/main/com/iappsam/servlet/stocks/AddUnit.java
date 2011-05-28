package com.iappsam.servlet.stocks;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

@WebServlet("/stocks/stocks/unit/AddUnit.do")
public class AddUnit extends HttpServlet {
	
	public AddUnit(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		Unit unit = new Unit();
		
		RequestDispatcher add = request.getRequestDispatcher("/stocks/stocks/SearchAllItemUnits.do");

		String unitInput = (String) request.getParameter("unitField");
		
		unit.setName(unitInput);
		
		request.setAttribute("unit", unit);
		
		try {
			itemManager.addUnit(unit);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add.forward(request, response);
		
	}
}