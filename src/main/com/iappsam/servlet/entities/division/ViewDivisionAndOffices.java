package com.iappsam.servlet.entities.division;

import java.io.IOException;
import java.util.ArrayList;
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	@SuppressWarnings({ "unused", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("start of viewing---------------------->");

		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

		String divisionID = request.getParameter("dOfficeID");
		
		if(divisionID==null)
			divisionID = (String)request.getAttribute("dOfficeID");
		DivisionOffice dOffice = null;
		List<DivisionOffice> offices = new ArrayList<DivisionOffice>();

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
				offices = doManager.getOfficesUnderDivision(dOffice.getDivisionName());
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
