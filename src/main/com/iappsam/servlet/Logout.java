package com.iappsam.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("inside the LOGOUT post!!!!!!!!!!!!!");

		HttpSession session = request.getSession();

		Enumeration<String> attributes = session.getAttributeNames();
		while (attributes.hasMoreElements()) {
			session.removeAttribute(attributes.nextElement());
		}
		session.invalidate();

		// RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
		// view.forward(request, response);

		response.sendRedirect("login");
	}

}
