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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("...inside menu.java");
		
		
		String username = (String)request.getAttribute("username");
		System.out.println("usernaem: "+username);
		Cleaner.clean(request);
//		String username = (String)request.getAttribute("username");
		request.setAttribute("username", username);
		request.getRequestDispatcher("MenuFrame.jsp").forward(request, response);
	}
}
