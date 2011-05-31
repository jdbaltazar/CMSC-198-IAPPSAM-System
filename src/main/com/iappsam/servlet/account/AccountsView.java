package com.iappsam.servlet.account;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Account;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class AccountView
 */
@WebServlet("/accounts/ViewAccounts.do")
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

		try {
			List<Account> accounts = aManager.getAllAccounts();
			for (int i = 0; i < accounts.size(); i++) {
				userName.add(accounts.get(i).getUsername());
				acctType.add(accounts.get(i).getType().toString());
				name.add(accounts.get(i).getPerson().getName());
			}
		} catch (org.hibernate.TransactionException e) {
			e.printStackTrace();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("userName", userName);
		request.setAttribute("acctType", acctType);
		request.setAttribute("name", name);
		request.setAttribute("listSize", "" + userName.size());

		RequestDispatcher view = request.getRequestDispatcher("../accounts/ViewAccounts.jsp");
		view.forward(request, response);
		// OutputStreamWriter out = new
		// OutputStreamWriter(response.getOutputStream());
		// out.write("fuck");
		// out.flush();
	}
}
