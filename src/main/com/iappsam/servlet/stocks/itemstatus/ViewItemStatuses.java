package com.iappsam.servlet.stocks.itemstatus;

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
import com.iappsam.entities.ItemStatus;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

@WebServlet("/stocks/stocks/ViewItemStatuses.do")
public class ViewItemStatuses extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7700104491260715251L;

	public ViewItemStatuses(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("ViewItemStatuses.jsp");
		
		List<ItemStatus> statuses = new ArrayList<ItemStatus>();
		
		try {
			statuses = itemManager.getAllItemStatus();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("itemStatuses", statuses);
		
		view.forward(request, response);
	}
}
