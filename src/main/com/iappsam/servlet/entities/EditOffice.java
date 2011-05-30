package com.iappsam.servlet.entities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println(".....inside editoffice.java");

		int officeID = Integer.parseInt((String) request.getParameter("officeID"));
		DivisionOffice dOffice = null, office = null;
		try {
			office = ManagerBin.doManager.getDivisionOffice(officeID);
			dOffice = ManagerBin.doManager.getDivisionOffice(office.getDivisionName(), null);

			request.setAttribute("dOfficeID", "" + dOffice.getId());
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (office != null) {
			request.setAttribute("office", office);
		}

		if (dOffice == null) {

			System.out.println("dOffice is NULL!!!!!!!!!!!!!!!!!!!!");
		}

		RequestDispatcher view = request.getRequestDispatcher("EditOffice.jsp");

		System.out.println("........outside editoffice.java");
		view.forward(request, response);

	}
}
