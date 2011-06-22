package com.iappsam.servlet.entities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.DivisionOffice;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ApplicationContext;

/**
 * Servlet implementation class AddOffice
 */
@WebServlet("/entities/division/AddOffice.do")
public class AddOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOffice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("....inside addoffice.java");
		
		int dOfficeID = Integer.parseInt(request.getParameter("dOfficeID"));
		
		DivisionOffice dOffice;
		try {
			dOffice = ApplicationContext.INSTANCE.getDivisionOfficeManager().getDivisionOffice(dOfficeID);
			request.setAttribute("dOffice", dOffice);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("AddOffice.jsp");
		view.forward(request, response);
	}

}
