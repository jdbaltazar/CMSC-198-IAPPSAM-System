package com.iappsam.servlet.stocks.disposal;

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
@WebServlet("/stocks/disposal")
public class DisposalServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3638228129630903356L;

	public static final String VIEW_DISPOSALS = "/stocks/disposals/ViewDisposals.jsp";
	public static final String ADD_DISPOSAL = "/stocks/disposals/AddDisposal.jsp";
	public static final String EDIT_DISPOSAL = "/stocks/disposals/EditDisposal.jsp";

	public static final String DISPOSAL_ACTION = "disposal-action";

	public static final String VIEW_DISPOSALS_ACTION = "view-disposals";
	public static final String ADD_DISPOSAL_ACTION = "add-disposal";
	public static final String EDIT_DISPOSAL_ACTION = "edit-disposal";
	public static final String SAVE_DISPOSAL_ACTION = "save-disposal";
	public static final String SAVE_EDITED_DISPOSAL_ACTION = "save-edited-disposal";

	public DisposalServlet() {
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

		if (action != null)
			action.process(request, response);
	}

	private Action parseAction(HttpServletRequest request) {

		String action = (String) request.getParameter(DISPOSAL_ACTION);

		if (action.equalsIgnoreCase(VIEW_DISPOSALS_ACTION))
			return new ViewDisposalsAction();
		if (action.equalsIgnoreCase(ADD_DISPOSAL_ACTION))
			return new AddDisposalAction();
		if (action.equalsIgnoreCase(EDIT_DISPOSAL_ACTION))
			return new EditDisposalAction();
		if (action.equalsIgnoreCase(SAVE_DISPOSAL_ACTION))
			return new SaveDisposalAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_DISPOSAL_ACTION))
			return new SaveEditedDisposalAction();

		return null;

	}
}