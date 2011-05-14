package com;

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
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
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

	private void failedResponse() {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> s = request.getAttributeNames();

		title = request.getParameter("title");
		name = request.getParameter("name");
		designation = request.getParameter("designation");
		employeeNumber = request.getParameter("employeeNumber");
		division = request.getParameter("division");
		userName = request.getParameter("userName");
		password = request.getParameter("password");
		reenterPassword = request.getParameter("reenterPassword");

		if (password == null || password.equals(reenterPassword) || name == null || designation == null || division == null || userName == null || reenterPassword == null)
			failedResponse();

		else
			acceptResponse();
	}

	private void acceptResponse() {
		Person person = new Person(title, name);
		PersonManager pManager = new PersonManagerSession();
		try {
			pManager.addPerson(person);

			// Account account = new Account(username, password,
			// "SPSO_PERSONNEL", person.getPersonID());
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

}
