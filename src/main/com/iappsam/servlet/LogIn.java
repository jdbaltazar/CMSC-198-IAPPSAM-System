package com.iappsam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Account;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn.do")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		if (evaluateLogin(userName, password))
			logInSuccess(request, response, userName);
		else
			logInFail(request, response);
	}

	private void logInSuccess(HttpServletRequest request, HttpServletResponse response, String userName) {
		AccountManager aManager = new AccountManagerSession();

		try {
			String pID = "" + aManager.getAccount(userName).getPersonID();
			request.setAttribute("personID", pID);
			request.setAttribute("userName", userName);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("../MenuFrame.jsp");
		try {
			if (view == null) {
				view = request.getRequestDispatcher("/MenuFrame.jsp");
			}
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void logInFail(HttpServletRequest request, HttpServletResponse response) {

		String passwordIsOK = "false";
		RequestDispatcher view = request.getRequestDispatcher("../Login.jsp");
		request.setAttribute("passwordIsOK", passwordIsOK);
		try {
			if (view == null) {
				view = request.getRequestDispatcher("/Login.jsp");
			}
			if (view != null)
				view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean evaluateLogin(String userName, String password) {
		// TODO Auto-generated method stub
		AccountManager aManager = new AccountManagerSession();
		try {
			if (userName.isEmpty() || password.isEmpty())
				return false;
			Account account = aManager.getAccount(userName);
			if (account != null)
				return account.comparePassword(password);
		} catch (TransactionException e) {
			return false;
		}
		return false;

	}

}
