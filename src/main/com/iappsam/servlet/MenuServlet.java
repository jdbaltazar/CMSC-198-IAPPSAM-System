package com.iappsam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.util.Cleaner;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8715294359026881395L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String username = (String) request.getAttribute("username");
//		request.setAttribute("username", username);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}
}
