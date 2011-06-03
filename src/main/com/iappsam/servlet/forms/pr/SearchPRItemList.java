package com.iappsam.servlet.forms.pr;

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
import com.iappsam.entities.forms.IIRUP;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.search.AbstractSearcher;
import com.iappsam.search.IIRUPSearcher;
import com.iappsam.search.ItemSearcher;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class SearchPRItemList
 */
@WebServlet({"/forms/purchase_request/search_pr_item_list.do","/forms/purchse_request/pr_form_additem.do"})
public class SearchPRItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPRItemList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbstractSearcher iSearcher = new ItemSearcher();
		List<Item> itemList = null;
		String searchItemField = (String) request.getParameter("searchItemField");

		try {
			if (searchItemField == null || searchItemField.isEmpty())
				itemList = ManagerBin.getInstance().iManager.getAllItems();
			else
				itemList = iSearcher.search((String) request.getParameter("searchItemField"));
			System.out.println("" + itemList.get(0));
			ArrayList<String> itemDescription = new ArrayList<String>();
			ArrayList<String> itemCategory = new ArrayList<String>();
			ArrayList<String> itemID = new ArrayList<String>();
			for (int i = 0; i < itemList.size(); i++) {
				itemCategory.add(itemList.get(i).getDescription());
				itemDescription.add(itemList.get(i).getDescription());
				itemID.add("" + itemList.get(i).getId());
			}
			request.setAttribute("itemCategory", itemCategory);
			request.setAttribute("itemDescription", itemDescription);
			request.setAttribute("itemID", itemID);
			RequestDispatcher view = request.getRequestDispatcher("pr_form_additem.jsp");
			view.forward(request, response);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
