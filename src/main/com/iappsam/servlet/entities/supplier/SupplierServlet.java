package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

@WebServlet("/supplier")
public class SupplierServlet extends HttpServlet {

	public static final String SEARCH_SUPPLIERS = "/entities/supplier/SearchSuppliers.jsp";
	public static final String ADD_SUPPLIER = "/entities/supplier/AddSupplier.jsp";
	public static final String ADD_SUPPLIER_FOR_EXISTING = "/entities/supplier/AddSupplierForExisting.jsp";
	public static final String VIEW_SUPPLIER = "/entities/supplier/ViewSupplier.jsp";
	public static final String CHANGE_SUPPLIER_CONTACT_PERSON = "/entities/supplier/ChangeSupplierContactPerson.jsp";

	public static final String SUPPLIER_ACTION = "supplier-action";
	public static final String VIEW_SUPPLIERS_ACTION = "view-suppliers";
	public static final String NEW_SUPPLIER_ACTION = "new-supplier";
	public static final String NEW_SUPPLIER_FOR_EXISTING_ACTION = "new-supplier-for-existing";
	public static final String SEARCH_SUPPLIERS_ACTION = "search-suppliers";
	public static final String VIEW_SUPPLIER_ACTION = "view-supplier";
	public static final String SAVE_SUPPLIER_ACTION = "save-supplier";
	public static final String SAVE_EDITED_SUPPLIER_ACTION = "save-edited-supplier";
	public static final String SAVE_SUPPLIER_FOR_CP_ACTION = "save-supplier-for-cp";
	public static final String CHANGE_SUPPLIER_CONTACT_PERSON_ACTION = "change-cp";
	public static final String SAVE_CHANGED_SUPPLIER_CONTACT_PERSON_ACTION = "save-changed-supplier-cp";

	public SupplierServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = parseAction(request);

		if (action != null)
			action.process(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(SUPPLIER_ACTION);

		if (action.equalsIgnoreCase(VIEW_SUPPLIERS_ACTION)) {
			Action viewAction = new ViewSuppliersAction();
			viewAction.process(request, response);
		} else if (action.equalsIgnoreCase(SEARCH_SUPPLIERS)) {
			Action searchSuppliersAction = new SearchSuppliersAction();
			searchSuppliersAction.process(request, response);
		} else if (action.equalsIgnoreCase(NEW_SUPPLIER_ACTION)) {
			Action newSupplierAction = new NewSupplierAction();
			newSupplierAction.process(request, response);
		} else if (action.equalsIgnoreCase(NEW_SUPPLIER_FOR_EXISTING_ACTION)) {
			Action newSupplierForExistingAction = new NewSupplierForExistingAction();
			newSupplierForExistingAction.process(request, response);
		} else if (action.equalsIgnoreCase(VIEW_SUPPLIER_ACTION)) {
			Action viewSupplierAction = new ViewSupplierAction();
			viewSupplierAction.process(request, response);
		} else if (action.equalsIgnoreCase(CHANGE_SUPPLIER_CONTACT_PERSON_ACTION)) {
			Action changeSupplierCPAction = new ChangeSupplierContactPersonAction();
			changeSupplierCPAction.process(request, response);
		}
	}

	private Action parseAction(HttpServletRequest request) {

		String action = (String) request.getParameter(SUPPLIER_ACTION);

		if (action.equalsIgnoreCase(VIEW_SUPPLIERS_ACTION))
			return new ViewSuppliersAction();
		if (action.equalsIgnoreCase(SEARCH_SUPPLIERS_ACTION))
			return new SearchSuppliersAction();
		if (action.equalsIgnoreCase(VIEW_SUPPLIER_ACTION))
			return new ViewSupplierAction();
		if (action.equalsIgnoreCase(NEW_SUPPLIER_ACTION))
			return new NewSupplierAction();
		if (action.equalsIgnoreCase(SAVE_SUPPLIER_ACTION))
			return new SaveSupplierAction();
		if (action.equalsIgnoreCase(SAVE_SUPPLIER_FOR_CP_ACTION))
			return new SaveSupplierToContactPersonAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_SUPPLIER_ACTION))
			return new SaveEditedSupplierAction();
		if (action.equalsIgnoreCase(SAVE_CHANGED_SUPPLIER_CONTACT_PERSON_ACTION))
			return new SaveEditedSupplierForExistingAction();
		return null;
	}

}
