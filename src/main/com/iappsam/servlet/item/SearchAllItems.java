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
import com.iappsam.search.AbstractSearcher;
import com.iappsam.search.ItemSearcher;
import com.iappsam.search.Searcher;
import com.iappsam.util.Managers;
import com.iappsam.util.Verifier;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("...inside search all items");

		String searchItemField = (String) request.getParameter("searchItemField");
		AbstractSearcher s = new ItemSearcher();
		List<Item> items = new ArrayList<Item>();
		List<Item> uniqueItems = new ArrayList<Item>();

		if (searchItemField == null || (searchItemField != null && searchItemField.equalsIgnoreCase(""))) {
			try {
				items = Managers.ITEM_MANAGER.getAllItems();
				uniqueItems = items;
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("keyword: " + searchItemField);
			items = s.search(searchItemField);
			boolean unique = true;
			for (Item item : items) {
				for (Item i : uniqueItems) {
					if (i.getId() == item.getId()) {
						unique = false;
					}
				}
				if (unique)
					uniqueItems.add(item);
			}
		}

		request.setAttribute("items", uniqueItems);

		RequestDispatcher view = request.getRequestDispatcher("../stocks/items/SearchItems.jsp");
		view.forward(request, response);
	}
}
