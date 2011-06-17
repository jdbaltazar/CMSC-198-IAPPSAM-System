package com.iappsam.servlet.account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Account;
import com.iappsam.AccountType;
import com.iappsam.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/accounts/viewing/update_account.do")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String title;
	private String name;
	private String userName;
	private String password;
	private String reenterPassword;
	private String acctType;
	private String oldPassword;
	private AccountManager aManager = new AccountManagerSession();
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		System.out.println(username);
		try {
			Account account = aManager.getAccount(username);

			request.setAttribute("account", account);

			request.setAttribute("starting", "true");
			RequestDispatcher view = request
					.getRequestDispatcher("update_account.jsp");
			request.setAttribute("isFinished", "Heyo");
			view.forward(request, response);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void failedResponse(HttpServletRequest request,
			HttpServletResponse response) {
		if (name.isEmpty())
			request.setAttribute("nameOK", "false");
		else
			request.setAttribute("nameOK", "true");
		if (password.isEmpty() || !password.equalsIgnoreCase(reenterPassword))
			request.setAttribute("passwordOK", "false");
		else
			request.setAttribute("passwordOK", "true");

		RequestDispatcher view = request
				.getRequestDispatcher("update_account.jsp");
		request.setAttribute("title", title);
		request.setAttribute("name", name);
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		title = request.getParameter("title");
		name = request.getParameter("name");
		oldPassword = request.getParameter("oldPassword");
		password = request.getParameter("password");
		reenterPassword = request.getParameter("reenterPassword");
		acctType = request.getParameter("acctType");
		userName = request.getParameter("userName");
		

		try {
			if (!name.isEmpty()
					&& !userName.isEmpty()
					&& !password.isEmpty()
					&& !reenterPassword.isEmpty()
					&& password.equalsIgnoreCase(reenterPassword)
					&& aManager.getAccount(userName).comparePassword(
							oldPassword)) {
				acceptResponse(request, response);
			} else
				failedResponse(request, response);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			failedResponse(request, response);
		}
	}

	private void acceptResponse(HttpServletRequest request,
			HttpServletResponse response) {
		PersonManager pManager = new PersonManagerSession();
		AccountManager aManager = new AccountManagerSession();
		Person person;
		if (name != null && userName != null && password != null
				&& reenterPassword != null
				&& password.equalsIgnoreCase(reenterPassword)) {
			if (title != null && !title.equalsIgnoreCase("null")
					&& !title.isEmpty())
				person = new Person(title, name);
			else
				person = new Person(name);
			try {

				/*
				 * Throws constraint violation exception, followed the call
				 * heirerchy and couldn't find where the bug is.... seems that
				 * when update is called, it performs an insert method.
				 */

				pManager.updatePerson(person);
				//

				request.setAttribute("person", person);
			} catch (TransactionException e) {
				failedResponse(request, response);
			} catch (DuplicateEntryException e) {
				failedResponse(request, response);
			}
			try {
				Account account = new Account();

				account.setPassword(password);
				account.setPerson(person);
				if (acctType
						.equalsIgnoreCase(AccountType.NON_SPSO_PERSONNEL_EMPLOYEE
								.toString())) {
					account.setType(AccountType.NON_SPSO_PERSONNEL_EMPLOYEE);
				} else if (acctType
						.equalsIgnoreCase(AccountType.NON_SPSO_PERSONNEL_HEAD
								.toString())) {
					account.setType(AccountType.NON_SPSO_PERSONNEL_HEAD);
				} else if (acctType.equalsIgnoreCase(AccountType.SPSO_PERSONNEL
						.toString())) {
					account.setType(AccountType.SPSO_PERSONNEL);
				} else if (acctType.equalsIgnoreCase(AccountType.SYSTEM_ADMIN
						.toString())) {
					account.setType(AccountType.SYSTEM_ADMIN);
				}
				aManager.updateAccount(account);
				request.setAttribute("account", account);
				request.setAttribute("userName", userName);
				RequestDispatcher view = request
						.getRequestDispatcher("ViewAccount.jsp");
				view.forward(request, response);
			} catch (TransactionException e) {
				failedResponse(request, response);
			} catch (ServletException e) {
				failedResponse(request, response);
			} catch (IOException e) {
				failedResponse(request, response);
			}
		}
	}
}