package com.iappsam.servlet.stocks.itemcondition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.servlet.stocks.itemunit.AddItemUnitAction;
import com.iappsam.servlet.stocks.itemunit.EditItemUnitAction;
import com.iappsam.servlet.stocks.itemunit.SaveEditedItemUnitAction;
import com.iappsam.servlet.stocks.itemunit.SaveItemUnitAction;
import com.iappsam.servlet.stocks.itemunit.ViewItemUnitsAction;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/stocks/item-cond")
public class ItemConditionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1710646675798724102L;

	public static final String VIEW_ITEM_CONDS = "/stocks/item_conds/ViewItemConditions.jsp";
	public static final String ADD_ITEM_COND = "/stocks/item_conds/AddItemCondition.jsp";
	public static final String EDIT_ITEM_COND = "/stocks/item_conds/EditItemCondition.jsp";

	public static final String ITEM_COND_ACTION = "item-cond-action";

	public static final String VIEW_ITEM_CONDS_ACTION = "view-item-conds";
	public static final String ADD_ITEM_COND_ACTION = "add-item-cond";
	public static final String EDIT_ITEM_COND_ACTION = "edit-item-cond";
	public static final String SAVE_ITEM_COND_ACTION = "save-item-cond";
	public static final String SAVE_EDITED_ITEM_COND_ACTION = "save-edited-item-cond";

	public ItemConditionServlet() {
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

		Action action = parseAction(request);

		if (action != null) {
			action.process(request, response);
		}

	}

	private Action parseAction(HttpServletRequest request) {

		String action = (String) request.getParameter(ITEM_COND_ACTION);

		if (action.equalsIgnoreCase(VIEW_ITEM_CONDS_ACTION))
			return new ViewItemCondsAction();
		if (action.equalsIgnoreCase(ADD_ITEM_COND_ACTION))
			return new AddItemCondAction();
		if (action.equalsIgnoreCase(EDIT_ITEM_COND_ACTION))
			return new EditItemCondAction();
		if (action.equalsIgnoreCase(SAVE_ITEM_COND_ACTION))
			return new SaveItemCondAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_ITEM_COND_ACTION))
			return new SaveEditedItemCondAction();

		return null;

	}
}