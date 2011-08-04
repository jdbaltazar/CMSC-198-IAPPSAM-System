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
@WebServlet("/accounts")
public class AccountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3714697957167302256L;

	public static final String SEARCH_ACCOUNTS = "/account/SearchEmployees.jsp";
	public static final String ADD_ACCOUNT = "/accounts/create_account.jsp";
	public static final String VIEW_ACCOUNTS="/accounts/ViewAccounts.jsp";
	public static final String VIEW_ACCOUNT = "/account/view_account.jsp";
	

	public static final String ACCOUNT_ACTION = "account-action";

	public static final String SEARCH_ACCOUNTS_ACTION = "search-accounts";
	public static final String VIEW_ACCOUNTS_ACTION="view-accounts";
	public static final String ADD_ACCOUNT_ACTION = "add-account";
	public static final String VIEW_ACCOUNT_ACTION = "view-account";
	public static final String SAVE_ACCOUNT_ACTION = "save-account";
	public static final String SAVE_EDITED_ACCOUNT_ACTION = "save-edited-account";
	public static final String CREATE_FROM_EXISTING="create-from-existing";
	public static final String SAVE_FOR_EXISTING="save-for-existing";

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
		if(action.equalsIgnoreCase(ADD_ACCOUNT_ACTION))
			return new AccountCreationAction();
		if(action.equalsIgnoreCase(VIEW_ACCOUNTS_ACTION))
			return new AccountsViewAction();
		if (action.equalsIgnoreCase(VIEW_ACCOUNT_ACTION))
			return new ViewAccountAction();
		if (action.equalsIgnoreCase(SAVE_ACCOUNT_ACTION))
			return new SaveAccountAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_ACCOUNT_ACTION))
			return new UpdateAccountAction();
		if(action.equalsIgnoreCase(CREATE_FROM_EXISTING))
				return new AccountCreationForExistingEmployeeAction();
		if(action.equalsIgnoreCase(SAVE_FOR_EXISTING))
				return new SaveAccountForExistingEmployeeAction();
		
		return null;
	}
	
	
}
