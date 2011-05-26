package com.iappsam.servlet.stocks;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

@WebServlet("/stocks/stocks/condition/AddCondition.do")
public class AddCondition extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddCondition(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		ItemCondition condition = new ItemCondition();
		
		RequestDispatcher add = request.getRequestDispatcher("/stocks/stocks/SearchAllItemConditions.do");

		String conditionInput = (String) request.getParameter("conditionField");
		
		condition.setItemCondition(conditionInput);
		
		request.setAttribute("condition", condition);
		
		try {
			itemManager.addItemCondition(condition);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add.forward(request, response);
		
	}
}
