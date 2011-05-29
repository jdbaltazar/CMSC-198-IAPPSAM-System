package com.iappsam.servlet.entities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;

/**
 * Servlet implementation class SaveDivisionEdit
 */
@WebServlet("/entities/division/SaveDivisionEdit.do")
public class SaveDivisionEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveDivisionEdit() {
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
		DivisionOffice dOffice = (DivisionOffice) request.getAttribute("dOffice");
		String divisionName = (String) request.getParameter("newName");
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("EditDivision.do");

		if (dOffice != null) {
			if (divisionName != null) {

				if (!divisionName.equalsIgnoreCase("")) {
					dOffice.setDivisionName(divisionName);

					try {
						doManager.updateDivisionOffice(dOffice);
						view = request.getRequestDispatcher("ViewDivisionAndOffices.jsp");
						request.setAttribute("dOfficeID", "" + dOffice.getId());
					} catch (TransactionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		view.forward(request, response);
	}

}
