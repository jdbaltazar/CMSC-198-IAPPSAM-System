package com.iappsam.servlet.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class UpdateDivisionOffice
 */
@WebServlet("/entities/division/ViewDivisionAndOffices.do")
public class ViewDivisionAndOffices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewDivisionAndOffices() {
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
	@SuppressWarnings({ "unused", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("start of viewing---------------------->");

		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

		String divisionID = (String) request.getParameter("dOfficeID");
		
		if(divisionID==null)
			divisionID = (String)request.getAttribute("dOfficeID");
		DivisionOffice dOffice = null;
		ArrayList<DivisionOffice> offices = new ArrayList<DivisionOffice>();

		RequestDispatcher view = null;

		try {

			dOffice = doManager.getDivisionOffice(Integer.parseInt(divisionID));
			System.out.println("division found: " + dOffice.getDivisionName());
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (dOffice != null) {
			List<DivisionOffice> dOffices = new ArrayList<DivisionOffice>();
			try {
				dOffices = doManager.getAllDivisionOffice();
				for (DivisionOffice d : dOffices) {
					if (d.getDivisionName().equalsIgnoreCase(dOffice.getDivisionName())) {
						if (d.getOfficeName() != null) {
							offices.add(d);
						}
					}
				}
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("end of viewing---------------------->");

		request.setAttribute("dOffice", dOffice);
		request.setAttribute("offices", offices);

		view = request.getRequestDispatcher("ViewDivisionAndOffices.jsp");
		view.forward(request, response);
	}
}
