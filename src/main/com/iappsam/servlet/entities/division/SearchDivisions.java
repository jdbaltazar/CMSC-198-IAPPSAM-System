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
 * Servlet implementation class SearchDivisionOffice
 */
@WebServlet("/entities/division/SearchDivisions.do")
public class SearchDivisions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchDivisions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<DivisionOffice> dos = new ArrayList<DivisionOffice>();
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		List<DivisionOffice> result = new ArrayList<DivisionOffice>();
		String query = request.getParameter("searchField");

		try {
			if (query != null && !query.isEmpty()) {

			} else {
				dos = doManager.getAllDivisionOffice();

				for (DivisionOffice d : dos) {
					if (d.getOfficeName() == null)
						result.add(d);
				}
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("divOffices", result);

		RequestDispatcher view = request.getRequestDispatcher("SearchDivisions.jsp");
		view.forward(request, response);
	}

}
