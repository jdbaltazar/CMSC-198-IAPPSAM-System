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
 * Servlet implementation class SaveDivisionUpdate
 */
@WebServlet("/divisions/SaveDivisionUpdate.do")
public class SaveDivisionUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveDivisionUpdate() {
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
		RequestDispatcher view = request.getRequestDispatcher("../divisions/SaveDivisionUpdate.do");
		String name = (String) request.getParameter("name");
		if (name != null) {
			if (!name.equalsIgnoreCase("")) {
				DivisionOffice dOffice = null;
				try {
					dOffice = ManagerBin.doManager.getDivisionOffice(name);
				} catch (TransactionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (dOffice != null) {
					dOffice.setDivisionName(name);
					try {
						ManagerBin.doManager.updateDivisionOffice(dOffice);
						System.out.println("updated division successfully!");
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
