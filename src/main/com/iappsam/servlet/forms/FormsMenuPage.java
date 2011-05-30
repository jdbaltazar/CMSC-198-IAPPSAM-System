package com.iappsam.servlet.forms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.util.Cleaner;

@WebServlet("/forms/formsmenu")
public class FormsMenuPage extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("...inside formsmenu.java");
		
		Cleaner.clean(request);
		request.getRequestDispatcher("FormsMenuPage.jsp").forward(request, response);
	}
}
