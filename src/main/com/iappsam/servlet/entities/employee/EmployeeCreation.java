package com.iappsam.servlet.entities.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Account;
import com.iappsam.entities.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class EmployeeCreation
 */
@WebServlet("/entities/createEmployee.do")
public class EmployeeCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String employeeID;
	private String password;
	private String confirmPassword;
	private String division;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("name");
		employeeID = request.getParameter("employeeID");
		password = request.getParameter("password");
		confirmPassword = request.getParameter("reenterPassword");
		division = request.getParameter("division");

		if (name.isEmpty() || employeeID.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || !password.equals(confirmPassword)) {
			addFail(request, response);
		}
		else 
			addSuccess(request,response);
	}

	private void addSuccess(HttpServletRequest request, HttpServletResponse response) {
//		PersonManager manager = new PersonManagerSession();
//		manager.ad
//
//		try {
//			request.setAttribute("title", title);
//			request.setAttribute("name", name);
//			request.setAttribute("designation", designation);
//			request.setAttribute("userName", userName);
//			request.setAttribute("password", password);
//			request.setAttribute("office", office);
//			request.setAttribute("division", division);
//			request.setAttribute("employeeNumber", employeeNumber);
//
//			RequestDispatcher view = request.getRequestDispatcher("../jsp/accounts/CreateAccountSuccess.jsp");
//			view.forward(request, response);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//	
//		} catch (TransactionException e) {
//			e.printStackTrace();
//		}
	}

	private void addFail(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			if (password == null || confirmPassword == null || !password.equals(confirmPassword))
				request.setAttribute("passIsOK", "false");
			else
				request.setAttribute("passIsOK", "true");

			if (name == null)
				request.setAttribute("nameIsOK", "false");
			else
				request.setAttribute("nameIsOK", "true");

			if (employeeID == null)
				request.setAttribute("employeeIDIsOK", "false");
			else
				request.setAttribute("employeeIDIsOK", "true");
			
			request.setAttribute("division", division);
			RequestDispatcher view = request.getRequestDispatcher("../jsp/entities/employees/CreateEmployeeFail.jsp");
			view.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
