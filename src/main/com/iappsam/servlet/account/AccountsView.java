package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class AccountView
 */
@WebServlet("/AccountsView")
public class AccountsView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountsView() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		AccountManager aManager = new AccountManagerSession();
		PersonManager pManager = new PersonManagerSession();

		ArrayList<String> userName = new ArrayList<String>();
		ArrayList<String> acctType = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		List<Account> accounts;
		try {
			accounts = aManager.getAllAccounts();
			for (int i = 0; i < accounts.size(); i++) {
				userName.add(accounts.get(i).getUsername());
				acctType.add(accounts.get(i).getAccountType());
				name.add(pManager.getPerson(accounts.get(i).getPersonID()).getName());
			}
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("userName", userName);
		request.setAttribute("acctType", acctType);
		request.setAttribute("name", name);

		RequestDispatcher view = request.getRequestDispatcher("../ViewAccounts.jsp");
		view.forward(request, response);
	}

}
