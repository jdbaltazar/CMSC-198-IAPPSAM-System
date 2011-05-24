package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.search.ItemSearcher;
import com.iappsam.search.Searcher;

/**
 * Servlet implementation class SearchAllItems
 */
@WebServlet("/items/SearchAllItems.do")
public class SearchAllItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchAllItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ItemManager iManager = new ItemManagerSession();
		Searcher s = new ItemSearcher();
		ArrayList<String> itemDescription = new ArrayList<String>();
		ArrayList<String> itemCategory = new ArrayList<String>();
		String searchItemField = (String) request
				.getParameter("searchItemField");

		List<Item> items = new ArrayList<Item>();

		if (searchItemField == null || searchItemField.equalsIgnoreCase("")) {
			try {
				items = iManager.getAllItems();
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			items = s.search(searchItemField);
		}
		for (Item i : items) {
			itemDescription.add(i.getDescription());
			itemCategory.add(i.getCategory());
		}
		request.setAttribute("itemDescription", itemDescription);
		request.setAttribute("itemCategory", itemCategory);

		RequestDispatcher view = request
				.getRequestDispatcher("../stocks/items/SearchItems.jsp");
		view.forward(request, response);

	}

}
