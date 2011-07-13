package com.iappsam.servlet.stocks.itemunit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/stocks/item-unit")
public class ItemUnitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214267555112198691L;
	
	public static final String VIEW_ITEM_UNITS = "/stocks/item_units/ViewItemUnits.jsp";
	public static final String ADD_ITEM_UNIT = "/stocks/item_units/AddItemUnit.jsp";
	public static final String EDIT_ITEM_UNIT = "/stocks/item_units/EditItemUnit.jsp";
	
	
	public static final String ITEM_UNIT_ACTION = "item-unit-action";
	
	public static final String VIEW_ITEM_UNITS_ACTION = "view-item-units";
	public static final String ADD_ITEM_UNIT_ACTION = "add-item-unit";
	public static final String EDIT_ITEM_UNIT_ACTION = "edit-item-unit";
	public static final String SAVE_ITEM_UNIT_ACTION = "save-item-unit";
	public static final String SAVE_EDITED_ITEM_UNIT_ACTION = "save-edited-item-unit";


	public ItemUnitServlet() {
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

		Action action = parseAction(request);

		if (action != null) {
			try {
				action.process(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private Action parseAction(HttpServletRequest request) {

		String action = (String) request.getParameter(ITEM_UNIT_ACTION);
		
		if (action.equalsIgnoreCase(VIEW_ITEM_UNITS_ACTION))
			return new ViewItemUnitsAction();
		if (action.equalsIgnoreCase(ADD_ITEM_UNIT_ACTION))
			return new AddItemUnitAction();
		if (action.equalsIgnoreCase(EDIT_ITEM_UNIT_ACTION))
			return new EditItemUnitAction();
		if (action.equalsIgnoreCase(SAVE_ITEM_UNIT_ACTION))
			return new SaveItemUnitAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_ITEM_UNIT_ACTION))
			return new SaveEditedItemUnitAction();
		
		return null;

	}
}