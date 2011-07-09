package com.iappsam.servlet.entities.division;

import java.io.IOException;
import java.util.List;

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

		int dOfficeID = Integer.parseInt(request.getParameter("dOfficeID"));
		String officeName = request.getParameter("officeName").trim();

		RequestDispatcher view = request.getRequestDispatcher("AddOffice.jsp");
		DivisionOffice office, newOffice;
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		try {
			office = doManager.getDivisionOffice(dOfficeID);
			DivisionOffice dOffice = doManager.getDivisionOffice(office.getDivisionName(), null);

			if (officeName != null && !officeName.equalsIgnoreCase("")) {
				newOffice = new DivisionOffice(office.getDivisionName(), officeName);
				doManager.addDivisionOffice(newOffice);
				List<DivisionOffice> offices = doManager.getOfficesUnderDivision(office.getDivisionName());

				request.setAttribute("offices", offices);
				request.setAttribute("dOfficeID", "" + dOffice.getId());
				view = request.getRequestDispatcher("ViewDivisionAndOffices.do");
			} else {
				request.setAttribute("dOffice", dOffice);
			}

		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view.forward(request, response);

	}

}