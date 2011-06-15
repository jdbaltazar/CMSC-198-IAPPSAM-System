package com.iappsam.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.search.AbstractSearcher;
import com.iappsam.search.ItemSearcher;
import com.iappsam.util.Managers;

@WebServlet(name = "Search.do", urlPatterns = { "/forms/iirup/SearchIIRUPItemList.do" })
public class SearchItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchItemList() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbstractSearcher iSearcher = new ItemSearcher();
		List<Item> itemList = null;
		String searchItemField = request.getParameter("searchItemField");

		try {
			if (searchItemField == null || searchItemField.isEmpty())
				itemList = Managers.INSTANCE.getItemManager().getAllItems();
			else
				itemList = iSearcher.search(request.getParameter("searchItemField"));
			System.out.println("" + itemList.get(0));
			ArrayList<String> itemDescription = new ArrayList<String>();
			ArrayList<String> itemCategory = new ArrayList<String>();
			ArrayList<String> itemID = new ArrayList<String>();
			for (int i = 0; i < itemList.size(); i++) {
				itemCategory.add(itemList.get(i).getDescription());
				itemDescription.add(itemList.get(i).getDescription());
				itemID.add("" + itemList.get(i).getId());
			}
			if (itemList.isEmpty())
				System.out.println("ajsdkasjd");
			if (itemDescription.isEmpty())
				System.out.println("ajsdkasjd");
			if (itemCategory.isEmpty())
				System.out.println("sadfasfdsaf");
			if (itemID.isEmpty())
				System.out.println("kjfdglkjdfhkljgfhlkfghdf");
			request.setAttribute("itemCategory", itemCategory);
			request.setAttribute("itemDescription", itemDescription);
			request.setAttribute("itemID", itemID);
			RequestDispatcher view = request.getRequestDispatcher("../iirup/IIRUAddItem2.jsp");
			view.forward(request, response);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
