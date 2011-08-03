package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3714697957167302256L;

	public static final String SEARCH_EMPLOYEES = "/entities/employees/SearchEmployees.jsp";
	public static final String ADD_EMPLOYEE = "/entities/employees/AddEmployee.jsp";
	public static final String VIEW_EMPLOYEE = "/entities/employees/ViewEmployee.jsp";

	public static final String EMPLOYEE_ACTION = "employee-action";

	public static final String SEARCH_EMPLOYEES_ACTION = "search-employees";
	public static final String ADD_EMPLOYEE_ACTION = "add-employee";
	public static final String VIEW_EMPLOYEE_ACTION = "view-employee";
	public static final String SAVE_EMPLOYEE_ACTION = "save-employee";
	public static final String SAVE_EDITED_EMPLOYEE_ACTION = "save-edited-employee";

	public EmployeeServlet() {
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

		String action = request.getParameter(EMPLOYEE_ACTION);

		if (action.equalsIgnoreCase(SEARCH_EMPLOYEES_ACTION))
			return new SearchEmployeesAction();
		if (action.equalsIgnoreCase(ADD_EMPLOYEE_ACTION))
			return new AddEmployeeAction();
		if (action.equalsIgnoreCase(VIEW_EMPLOYEE_ACTION))
			return new ViewEmployeeAction();
		if (action.equalsIgnoreCase(SAVE_EMPLOYEE_ACTION))
			return new SaveEmployeeAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_EMPLOYEE_ACTION))
			return new SaveEditedEmployeeAction();

		return null;
	}
}
