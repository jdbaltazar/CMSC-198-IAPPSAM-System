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
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;

/**
 * Servlet implementation class SaveOffice
 */
@WebServlet("/entities/division/SaveOffice.do")
public class SaveOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveOffice() {
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
		System.out.println("....inside saveoffice.java");

		RequestDispatcher view = request.getRequestDispatcher("AddOffice.jsp");

		// String divisionName = (String)request.getParameter("divisionName");

		//
		// System.out.println("divisionname: "+divisionName);
		// System.out.println("officename: "+officeName);

		int dOfficeID = Integer.parseInt((String) request.getParameter("dOfficeID"));
		String officeName = (String) request.getParameter("officeName");

		if (officeName != null) {
			if (!officeName.equalsIgnoreCase("")) {

				DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
				DivisionOffice dOffice;
				try {
					dOffice = doManager.getDivisionOffice(dOfficeID);
					DivisionOffice office = new DivisionOffice(dOffice.getDivisionName(), officeName);
					doManager.addDivisionOffice(office);
					request.setAttribute("dOfficeID", "" + dOffice.getId());
					view = request.getRequestDispatcher("ViewDivisionAndOffices.do");
				} catch (TransactionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DuplicateEntryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println("end of saving office");
		view.forward(request, response);
	}

}
