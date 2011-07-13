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
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.util.ApplicationContext;

/**
 * Servlet implementation class SaveDivisionEdit
 */
@WebServlet("/entities/division/SaveOfficeEdit.do")
public class SaveOfficeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveOfficeEdit() {
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

		int officeID = Integer.parseInt(request.getParameter("officeID"));
		String newName = request.getParameter("newName").trim();

		RequestDispatcher view = request.getRequestDispatcher("EditOffice.jsp");
		DivisionOffice office;
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

		try {
			office = doManager.getDivisionOffice(officeID);
			if (newName != null && !newName.equalsIgnoreCase("")) {
				office.setOfficeName(newName);
				doManager.updateDivisionOffice(office);
				List<DivisionOffice> offices = doManager.getOfficesUnderDivision(office.getDivisionName());
				DivisionOffice dOffice = doManager.getDivisionOffice(office.getDivisionName(), null);
				request.setAttribute("offices", offices);
				request.setAttribute("dOfficeID", ""+dOffice.getId());
				view = request.getRequestDispatcher("ViewDivisionAndOffices.do");
			} else {
				request.setAttribute("office", office);
			}

		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view.forward(request, response);
	}

}
