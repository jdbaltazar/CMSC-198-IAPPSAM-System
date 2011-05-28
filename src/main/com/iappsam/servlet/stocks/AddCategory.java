package com.iappsam.servlet.stocks;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

@WebServlet("/stocks/stocks/AddCategory.do")
public class AddCategory extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddCategory() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		ItemCategory category = new ItemCategory();

		RequestDispatcher add = request.getRequestDispatcher("SearchAllItemCategories.do");

		String categoryInput = (String) request.getParameter("categoryField");

		if (!categoryInput.equals("")) {
			category.setName(categoryInput);

			request.setAttribute("category", category);

			try {
				itemManager.addItemCategory(category);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else{
			add = request.getRequestDispatcher("AddItemCategory.jsp");
		}
		
		add.forward(request, response);
	}
}
