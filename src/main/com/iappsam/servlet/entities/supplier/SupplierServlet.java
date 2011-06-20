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
	public static final String ADD_SUPPLIER = "/entities/supplier/AddSupplier.jsp";
	public static final String VIEW_SUPPLIER = "/entities/supplier/ViewSupplier.jsp";

	public static final String SUPPLIER_ACTION = "supplier-action";
	public static final String VIEW_SUPPLIERS_ACTION = "view-suppliers";
	public static final String NEW_SUPPLIER_ACTION = "new-supplier";
	public static final String SEARCH_SUPPLIERS_ACTION = "search-suppliers";
	public static final String VIEW_SUPPLIER_ACTION = "view-supplier";
	public static final String EDIT_SUPPLIER_ACTION = "edit-supplier";
	public static final String SAVE_SUPPLIER_ACTION = "save-supplier";

	public SupplierServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = parseAction(request);

		try {
			if (action != null)
				action.process(request, response);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	private Action parseAction(HttpServletRequest request) {

		String action = (String) request.getParameter(SUPPLIER_ACTION);

		if (action.equalsIgnoreCase(VIEW_SUPPLIERS_ACTION))
			return new ViewSuppliersAction();
		if (action.equalsIgnoreCase(NEW_SUPPLIER_ACTION))
			return new NewSupplierAction();
		return null;

		// String newParam = request.getParameter(ItemParameter.NEW_ITEM);
		// String id = request.getParameter(ItemParameter.ITEM_ID);
		// String q = request.getParameter(ItemParameter.QUERY);
		//
		// if (newParam != null && newParam.equals("item")) {
		// return newItem;
		// } else if (id != null) {
		// return viewItem;
		// } else if (q != null)
		// return searchItems;
		//
		// return listItems;
	}

}
