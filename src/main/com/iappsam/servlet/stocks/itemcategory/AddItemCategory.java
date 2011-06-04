package com.iappsam.servlet.stocks.itemcategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.Verifier;

@WebServlet("/stocks/stocks/AddItemCategory.do")
public class AddItemCategory extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddItemCategory() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ItemManager itemManager = new ItemManagerSession();
		ItemCategory category = new ItemCategory();

		RequestDispatcher add = request.getRequestDispatcher("AddItemCategory.jsp");
		
		String categoryInput = (String) request.getParameter("categoryField");

		if (Verifier.validEntry(categoryInput)) {
			category.setName(categoryInput);
			try {
				itemManager.addItemCategory(category);
				add = request.getRequestDispatcher("ViewItemCategories.do");
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
