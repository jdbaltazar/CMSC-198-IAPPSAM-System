package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ApplicationContext;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/supplier")
public class SupplierServlet extends HttpServlet {

	public static final String SEARCH_SUPPLIERS = "/entities/supplier/SearchSuppliers.jsp";

	private Action vSuppliersAction;

	public SupplierServlet() {
		super();
		vSuppliersAction = new ViewSuppliersAction();

		// addItem = new AddItemAction(m.getItemManager());
		// newItem = new NewItemAction(m.getItemManager());
		// viewItem = new ViewItemAction(m.getItemManager());
		// searchItems = new SearchItemsAction(m.getItemSearcher());
		// listItems = new ListItemsAction(m.getItemManager());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			parseAction(request).process(request, response);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			parseAction(request).process(request, response);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Action parseAction(HttpServletRequest request) {
		
		return vSuppliersAction;

//		String newParam = request.getParameter(ItemParameter.NEW_ITEM);
//		String id = request.getParameter(ItemParameter.ITEM_ID);
//		String q = request.getParameter(ItemParameter.QUERY);
//
//		if (newParam != null && newParam.equals("item")) {
//			return newItem;
//		} else if (id != null) {
//			return viewItem;
//		} else if (q != null)
//			return searchItems;
//
//		return listItems;
	}

}
