package com.iappsam.servlet.entities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.DivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.util.Verifier;

/**
 * Servlet implementation class SaveDivisionOffice
 */
@WebServlet("/entities/division/SaveDivision.do")
public class SaveDivision extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveDivision() {
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

		RequestDispatcher view = request.getRequestDispatcher("AddDivision.jsp");
		String divisionName = request.getParameter("divisionName").trim();

		if (Verifier.validEntry(divisionName)) {
			DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
			DivisionOffice dOffice = new DivisionOffice(divisionName, null);
			try {
				doManager.addDivisionOffice(dOffice);
				System.out.println("Saved division successfully!");
				view = request.getRequestDispatcher("SearchDivisions.do");
				view.forward(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				view = request.getRequestDispatcher("AddDivision.jsp");
				request.setAttribute("isReturning", "true");
				view.forward(request, response);
			}
		} else {
			view = request.getRequestDispatcher("AddDivision.jsp");
			request.setAttribute("isEmpty", "true");
			view.forward(request, response);
		}

	}
}
