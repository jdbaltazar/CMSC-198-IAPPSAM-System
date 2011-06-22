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
	public static final String ADD_SUPPLIER_FOR_EXISTING = "/entities/supplier/AddSupplierForExisting.jsp";
	public static final String VIEW_SUPPLIER = "/entities/supplier/ViewSupplier.jsp";
	// public static final String EDIT_SUPPLIER =
	// "/entities/supplier/EditSupplier.jsp";
	public static final String CHANGE_SUPPLIER_CONTACT_PERSON = "/entities/supplier/ChangeSupplierContactPerson.jsp";

	public static final String SUPPLIER_ACTION = "supplier-action";
	public static final String VIEW_SUPPLIERS_ACTION = "view-suppliers";
	public static final String NEW_SUPPLIER_ACTION = "new-supplier";
	public static final String NEW_SUPPLIER_FOR_EXISTING_ACTION = "new-supplier-for-existing";
	public static final String SEARCH_SUPPLIERS_ACTION = "search-suppliers";
	public static final String VIEW_SUPPLIER_ACTION = "view-supplier";
	// public static final String EDIT_SUPPLIER_ACTION = "edit-supplier";
	public static final String SAVE_SUPPLIER_ACTION = "save-supplier";
	public static final String CHANGE_SUPPLIER_CONTACT_PERSON_ACTION = "change-cp";

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
		String action = request.getParameter(SUPPLIER_ACTION);

		if (action.equalsIgnoreCase(VIEW_SUPPLIERS_ACTION)) {
			Action viewAction = new ViewSuppliersAction();
			try {
				viewAction.process(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equalsIgnoreCase(NEW_SUPPLIER_ACTION)) {
			Action newSupplierAction = new NewSupplierAction();
			try {
				newSupplierAction.process(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equalsIgnoreCase(NEW_SUPPLIER_FOR_EXISTING_ACTION)) {
			Action newSupplierForExistingAction = new NewSupplierForExistingAction();
			try {
				newSupplierForExistingAction.process(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equalsIgnoreCase(VIEW_SUPPLIER_ACTION)) {
			Action viewSupplierAction = new ViewSupplierAction();
			try {
				viewSupplierAction.process(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (action.equalsIgnoreCase(CHANGE_SUPPLIER_CONTACT_PERSON_ACTION)) {
			Action changeSupplierCPAction = new ChangeSupplierContactPersonAction();
			try {
				changeSupplierCPAction.process(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Action parseAction(HttpServletRequest request) {

		String action = (String) request.getParameter(SUPPLIER_ACTION);

		if (action.equalsIgnoreCase(VIEW_SUPPLIERS_ACTION))
			return new ViewSuppliersAction();
		if (action.equalsIgnoreCase(NEW_SUPPLIER_ACTION))
			return new NewSupplierAction();
		if (action.equalsIgnoreCase(SAVE_SUPPLIER_ACTION))
			return new SaveSupplierAction();
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
