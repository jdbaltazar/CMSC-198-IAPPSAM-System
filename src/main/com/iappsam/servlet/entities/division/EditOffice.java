package com.iappsam.servlet.entities.division;

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
 * Servlet implementation class EditOffice
 */
@WebServlet("/entities/division/EditOffice.do")
public class EditOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditOffice() {
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

		System.out.println(".....inside editoffice.java");

		int officeID = Integer.parseInt(request.getParameter("officeID"));
		DivisionOffice office = null;
		try {
			office = ApplicationContext.INSTANCE.getDivisionOfficeManager().getDivisionOffice(officeID);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("office", office);
		RequestDispatcher view = request.getRequestDispatcher("EditOffice.jsp");

		System.out.println("........outside editoffice.java");
		view.forward(request, response);

	}
}