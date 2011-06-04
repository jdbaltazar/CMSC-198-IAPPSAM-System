package com.iappsam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iappsam.LoginModule;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToIndexJsp(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter(USERNAME);
		String password = (String) request.getParameter(PASSWORD);

		LoginModule loginModule = new LoginModule();
		if (loginModule.login(username, password))
			forwardToMenuFrameJsp(request, response, username);
		else
			logInFail(request, response);
	}

	private void forwardToMenuFrameJsp(HttpServletRequest request, HttpServletResponse response, String username) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("menu.jsp");
		HttpSession session = request.getSession();

		session.setAttribute("username", username);
		session.setMaxInactiveInterval(30);

		view.forward(request, response);
	}

	private void logInFail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passwordIsOK = "false";
		request.setAttribute("passwordIsOK", passwordIsOK);
		forwardToIndexJsp(request, response);
	}

	private void forwardToIndexJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view;
		view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}
}
