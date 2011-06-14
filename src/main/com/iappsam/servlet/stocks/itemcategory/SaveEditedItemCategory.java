package com.iappsam.servlet.stocks.itemcategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;
import com.iappsam.util.Verifier;

/**
 * Servlet implementation class SaveEditedItemCategory
 */
@WebServlet("/stocks/stocks/SaveEditedItemCategory.do")
public class SaveEditedItemCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEditedItemCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("inside saveediteditemcategory.java");

		RequestDispatcher save = request.getRequestDispatcher("EditItemCategory.do");
		int itemCategoryID = Integer.parseInt(request.getParameter("itemCategoryID"));
		String name = request.getParameter("categoryField");

		ItemCategory itemCategory = null;

		try {
			itemCategory = Managers.INSTANCE.getItemManager().getItemCategory(itemCategoryID);
			if (Verifier.validEntry(name)) {
				itemCategory.setName(name);
				Managers.INSTANCE.getItemManager().updateItemCategory(itemCategory);
				save = request.getRequestDispatcher("ViewItemCategories.do");
			} else {
				request.setAttribute("itemCategory", itemCategory);
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("itemCategory", itemCategory);
		}

		save.forward(request, response);

	}

}
