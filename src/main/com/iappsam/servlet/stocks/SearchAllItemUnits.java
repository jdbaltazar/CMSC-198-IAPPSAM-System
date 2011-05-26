package com.iappsam.servlet.stocks;

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

@WebServlet("/stocks/stocks/SearchAllItemUnits.do")
public class SearchAllItemUnits extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchAllItemUnits(){
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
		ItemManager itemManager = new ItemManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("../../stocks/stocks/unit/ItemUnit.jsp");
		
		ArrayList<String> itemUnit = new ArrayList<String>();
		
		List<Unit> units = new ArrayList<Unit>();
		
		try {
			units = itemManager.getAllUnits();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Unit u: units)
			itemUnit.add(u.getUnit());
		
		request.setAttribute("itemUnit", itemUnit);
		
		view.forward(request, response);
	}
}
