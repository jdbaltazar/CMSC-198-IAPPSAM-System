package com.iappsam.servlet.entities.division;

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
 * Servlet implementation class DivisionOfficeServlet
 */
@WebServlet("/division-office")
public class DivisionOfficeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2690075409427256729L;

	public static final String ADD_DIVISION = "/entities/division/AddDivision.jsp";
	public static final String ADD_OFFICE = "/entities/division/AddOffice.jsp";
	public static final String EDIT_DIVISION = "/entities/division/EditDivision.jsp";
	public static final String EDIT_OFFICE = "/entities/division/EditOffice.jsp";
	public static final String VIEW_DIVISIONS = "/entities/division/ViewDivisions.jsp";
	public static final String VIEW_OFFICES = "/entities/division/ViewOffices.jsp";

	public static final String DIVISION_OFFICE_ACTION = "division-office-action";

	public static final String VIEW_DIVISIONS_ACTION = "view-divisions";
	public static final String VIEW_OFFICES_ACTION = "view-offices";
	public static final String ADD_DIVISION_ACTION = "add-division";
	public static final String ADD_OFFICE_ACTION = "add-office";
	public static final String EDIT_DIVISION_ACTION = "edit-division";
	public static final String EDIT_OFFICE_ACTION = "edit-office";
	public static final String SAVE_DIVISION_ACTION = "save-division";
	public static final String SAVE_OFFICE_ACTION = "save-office";
	public static final String SAVE_EDITED_DIVISION_ACTION = "save-edited-division";
	public static final String SAVE_EDITED_OFFICE_ACTION = "save-edited-office";

	public DivisionOfficeServlet() {
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

		String action = (String) request.getParameter(DIVISION_OFFICE_ACTION);
		
		
		if (action.equalsIgnoreCase(VIEW_DIVISIONS_ACTION))
			return new ViewDivisionsAction();
		if(action.equalsIgnoreCase(VIEW_OFFICES_ACTION))
			return new ViewOfficesAction();
		if(action.equalsIgnoreCase(ADD_DIVISION_ACTION))
			return new AddDivisionAction();
		if(action.equalsIgnoreCase(ADD_OFFICE_ACTION))
			return new AddOfficeAction();
		if(action.equalsIgnoreCase(EDIT_DIVISION_ACTION))
			return new EditDivisionAction();
		if(action.equalsIgnoreCase(EDIT_OFFICE_ACTION))
			return new EditOfficeAction();
		if(action.equalsIgnoreCase(SAVE_DIVISION_ACTION))
			return new SaveDivisionAction();
		if(action.equalsIgnoreCase(SAVE_OFFICE_ACTION))
			return new SaveOfficeAction();
		if(action.equalsIgnoreCase(SAVE_EDITED_DIVISION_ACTION))
			return new SaveEditedDivisionAction();
		if(action.equalsIgnoreCase(SAVE_EDITED_OFFICE_ACTION))
			return new SaveEditedOfficeAction();

		return null;

	}

}
