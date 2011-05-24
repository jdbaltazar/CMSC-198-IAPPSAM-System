package com.iappsam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iappsam.entities.Account;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.util.HibernateUtil;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	public static final String PASSWORD = "password";
	public static final String USERNAME = "username";
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToIndexJsp(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter(USERNAME);
		String password = (String) request.getParameter(PASSWORD);

		if (evaluateLogin(username, password))
			logInSuccess(request, response, username);
		else
			logInFail(request, response);
	}

	private void logInSuccess(HttpServletRequest request, HttpServletResponse response, String username) {
		request.setAttribute("username", username);
		forwardToMenuFrameJsp(request, response, username);
	}

	private void forwardToMenuFrameJsp(HttpServletRequest request, HttpServletResponse response, String username) {
		try {
			RequestDispatcher view = request.getRequestDispatcher("/MenuFrame.jsp");
			HttpSession session = request.getSession();

			if (session.isNew()) {
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(30);
			}
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void logInFail(HttpServletRequest request, HttpServletResponse response) {
		String passwordIsOK = "false";
		request.setAttribute("passwordIsOK", passwordIsOK);
		try {
			forwardToIndexJsp(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void forwardToIndexJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view;
		view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
	}

	private boolean evaluateLogin(String username, String password) {
		if (HibernateUtil.hotBoot())
			return HibernateUtil.evaluate(username, password);
		else
			return evaluateNotFirstRun(username, password);
	}

	private boolean evaluateNotFirstRun(String userName, String password) {
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
