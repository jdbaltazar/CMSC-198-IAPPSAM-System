package com.iappsam.servlet.account;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/employee")
public class AccountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3714697957167302256L;

	public static final String SEARCH_ACCOUNTS = "/account/SearchEmployees.jsp";
	public static final String ADD_ACCOUNT = "/account/AddEmployee.jsp";
	public static final String VIEW_ACCOUNT = "/account/ViewEmployee.jsp";

	public static final String ACCOUNT_ACTION = "account-action";

	public static final String SEARCH_ACCOUNTS_ACTION = "search-accounts";
	public static final String ADD_ACCOUNT_ACTION = "add-account";
	public static final String VIEW_ACCOUNT_ACTION = "view-account";
	public static final String SAVE_ACCOUNT_ACTION = "save-account";
	public static final String SAVE_EDITED_ACCOUNT_ACTION = "save-edited-account";

	public AccountServlet() {
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

		String action = (String) request.getParameter(ACCOUNT_ACTION);

//		if (action.equalsIgnoreCase(SEARCH_ACCOUNTS_ACTION))
//			return new SearchEmployeesAction();
//		if (action.equalsIgnoreCase(ADD_ACCOUNT_ACTION))
//			return new AddEmployeeAction();
//		if (action.equalsIgnoreCase(VIEW_ACCOUNT_ACTION))
//			return new ViewEmployeeAction();
//		if (action.equalsIgnoreCase(SAVE_ACCOUNT_ACTION))
//			return new SaveEmployeeAction();
//		if (action.equalsIgnoreCase(SAVE_EDITED_ACCOUNT_ACTION))
//			return new SaveEditedEmployeeAction();

		return null;
	}
}
