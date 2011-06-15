package com.iappsam.servlet.entities;

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

		System.out.println("inside savedivisionedit........");
		RequestDispatcher view = request.getRequestDispatcher("EditDivision.jsp");

		String dOfficeID = request.getParameter("dOfficeID");
		System.out.println("dOfficeID: " + dOfficeID);
		String newName = request.getParameter("newName");
		System.out.println("new name: " + newName);

		if (dOfficeID != null) {
			DivisionOffice dOffice = null;
			DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

			try {
				dOffice = doManager.getDivisionOffice(Integer.parseInt(dOfficeID));
				if (dOffice != null && newName != null) {
					if (!newName.equalsIgnoreCase("")) {
						List<DivisionOffice> dOffices = doManager.getAllDivisionOffice();
						for (DivisionOffice d : dOffices) {
							if (d.getDivisionName().equalsIgnoreCase(dOffice.getDivisionName()))
								d.setDivisionName(newName);
							doManager.updateDivisionOffice(dOffice);
						}
						dOffice.setDivisionName(newName);
						doManager.updateDivisionOffice(dOffice);
						request.setAttribute("dOfficeID", dOfficeID);
						view = request.getRequestDispatcher("ViewDivisionAndOffices.do");
					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		view.forward(request, response);
	}

}
