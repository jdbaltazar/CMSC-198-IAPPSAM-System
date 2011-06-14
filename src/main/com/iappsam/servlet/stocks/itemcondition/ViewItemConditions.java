package com.iappsam.servlet.stocks.itemcondition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCondition;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

@WebServlet("/stocks/stocks/ViewItemConditions.do")
public class ViewItemConditions extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7700104491260715251L;

	public ViewItemConditions(){
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("ViewItemConditions.jsp");
		
		List<ItemCondition> itemConditions = new ArrayList<ItemCondition>();
		
		try {
			itemConditions = itemManager.getAllItemCondition();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("itemConditions", itemConditions);
		
		view.forward(request, response);
	}
}
