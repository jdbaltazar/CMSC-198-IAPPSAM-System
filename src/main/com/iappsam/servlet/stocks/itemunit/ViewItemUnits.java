package com.iappsam.servlet.stocks.itemunit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.Managers;

@WebServlet("/stocks/stocks/ViewItemUnits.do")
public class ViewItemUnits extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewItemUnits() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("..........inside view item units.java");

		RequestDispatcher view = request.getRequestDispatcher("ViewItemUnits.jsp");

		List<Unit> units = new ArrayList<Unit>();

		try {
			units = Managers.ITEM_MANAGER.getAllUnits();
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("itemUnits", units);
		view.forward(request, response);
	}
}