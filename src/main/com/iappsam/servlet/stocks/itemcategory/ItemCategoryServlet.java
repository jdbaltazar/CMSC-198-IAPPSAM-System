package com.iappsam.servlet.stocks.itemcategory;

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
@WebServlet("/stocks/item-cat")
public class ItemCategoryServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2106015542243587107L;
	
	public static final String VIEW_ITEM_CATS = "/stocks/item_cats/ViewItemCategories.jsp";
	public static final String ADD_ITEM_CAT = "/stocks/item_cats/AddItemCategory.jsp";
	public static final String EDIT_ITEM_CAT = "/stocks/item_cats/EditItemCategory.jsp";
	
	
	public static final String ITEM_CAT_ACTION = "item-cat-action";
	
	public static final String VIEW_ITEM_CATS_ACTION = "view-item-cats";
	public static final String ADD_ITEM_CAT_ACTION = "add-item-cat";
	public static final String EDIT_ITEM_CAT_ACTION = "edit-item-cat";
	public static final String SAVE_ITEM_CAT_ACTION = "save-item-cat";
	public static final String SAVE_EDITED_ITEM_CAT_ACTION = "save-edited-item-cat";


	public ItemCategoryServlet() {
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

		String action = (String) request.getParameter(ITEM_CAT_ACTION);
		
		if (action.equalsIgnoreCase(VIEW_ITEM_CATS_ACTION))
			return new ViewItemCatsAction();
		if (action.equalsIgnoreCase(ADD_ITEM_CAT_ACTION))
			return new AddItemCatAction();
		if (action.equalsIgnoreCase(EDIT_ITEM_CAT_ACTION))
			return new EditItemCatAction();
		if (action.equalsIgnoreCase(SAVE_ITEM_CAT_ACTION))
			return new SaveItemCatAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_ITEM_CAT_ACTION))
			return new SaveEditedItemCatAction();
		
		return null;

	}
}