package com.iappsam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
 * Servlet implementation class CreateAccount
 */
@WebServlet("/accounts/accountCreate.do")
public class AccountCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String title;
	String name;
	String designation;
	String employeeNumber;
	String division;
	String office;
	String userName;
	String password;
	String reenterPassword;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void failedResponse(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (userName == null)
				request.setAttribute("usernameIsOk", "false");
			else
				request.setAttribute("usernameIsOK", "true");
			if (password == null || reenterPassword == null || !password.equals(reenterPassword))
				request.setAttribute("passIsOK", "false");
			else
				request.setAttribute("passIsOK", "true");

			if (name == null)
				request.setAttribute("nameIsOK", "false");
			else
				request.setAttribute("nameIsOK", "true");

			if (designation == null)
				request.setAttribute("designationIsOK", "false");
			else
				request.setAttribute("designationIsOK", "true");
			RequestDispatcher view = request.getRequestDispatcher("../jsp/accounts/CreateAccountFail.jsp");
			view.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		title = request.getParameter("title");
		name = request.getParameter("name");
		designation = request.getParameter("designation");
		office = request.getParameter("office");
		employeeNumber = request.getParameter("employeeNumber");
		division = request.getParameter("division");
		userName = request.getParameter("userName");
		password = request.getParameter("password");
		reenterPassword = request.getParameter("reenterPassword");

		if (password.isEmpty() || !password.equals(reenterPassword) || name.isEmpty() || designation.isEmpty() || division.isEmpty() || userName.isEmpty() || reenterPassword.isEmpty()) {
			failedResponse(request, response);
			System.out.println("output");
		} else
			acceptResponse(request, response);
	}

	private void acceptResponse(HttpServletRequest request, HttpServletResponse response) {
		Person person = new Person(title, name);
		PersonManager pManager = new PersonManagerSession();
		AccountManager aManager = new AccountManagerSession();
		try {
			request.setAttribute("title", title);
			request.setAttribute("name", name);
			request.setAttribute("designation", designation);
			request.setAttribute("userName", userName);
			request.setAttribute("password", password);
			request.setAttribute("office", office);
			request.setAttribute("division", division);
			request.setAttribute("employeeNumber", employeeNumber);

			RequestDispatcher view = request.getRequestDispatcher("../jsp/accounts/CreateAccountSuccess.jsp");
			view.forward(request, response);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pManager.addPerson(person);

			 Account account = new Account(userName, password,
			 "SPSO_PERSONNEL", person.getPersonID());
			 aManager.addAccount(account);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

}
