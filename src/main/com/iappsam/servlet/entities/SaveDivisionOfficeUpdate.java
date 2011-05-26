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
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class SaveDivisionOfficeUpdate
 */
@WebServlet("/divisions/SaveDivisionOfficeUpdate.do")
public class SaveDivisionOfficeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveDivisionOfficeUpdate() {
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
		
		System.out.println("inside update division office!!!!!!!!!!!!!!!!!");
		RequestDispatcher view = request.getRequestDispatcher("../divisions/SaveDivisionOfficeUpdate.do");
		String division = (String) request.getParameter("inDivision");
		String office = (String) request.getParameter("officeName");
		if (division != null && office != null) {
			if (!(division.equalsIgnoreCase("") || office.equalsIgnoreCase(""))) {
				DivisionOffice dOffice = null;

				try {
					dOffice = ManagerBin.doManager.getDivisionOffice(division);
				} catch (TransactionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (dOffice != null) {
					dOffice.setDivisionName(division);
					if (office != null)
						dOffice.setOfficeName(office);
					try {
						ManagerBin.doManager.updateDivisionOffice(dOffice);
						System.out.println("Updated division office successfully!");
						view = request.getRequestDispatcher("../divisions/SearchDivisionOffice.do");
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
