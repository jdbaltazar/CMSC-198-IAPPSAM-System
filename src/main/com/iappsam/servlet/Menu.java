package com.iappsam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.util.Cleaner;

@WebServlet("/menu")
public class Menu extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = (String) request.getAttribute("username");
//		Cleaner.clean(request);
		request.setAttribute("username", username);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}
}
