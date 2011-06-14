package com.iappsam.servlet.forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.util.Cleaner;

@WebServlet("/forms/viewformsmenu")
public class ViewFormsMenuPage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("...inside viewformsmenu.java");
		
		Cleaner.clean(request);
		request.getRequestDispatcher("ViewFormsMenuPage.jsp").forward(request, response);
	}
}
