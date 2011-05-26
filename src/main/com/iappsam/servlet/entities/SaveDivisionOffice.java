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

@WebServlet("/divisions/SaveDivisionOffice.do")
public class SaveDivisionOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveDivisionOffice() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("../divisions/AddDivisionOffice.do");
		String division = (String) request.getParameter("inDivision");
		String office = (String) request.getParameter("officeName");
		if (division != null && office != null) {
			if (!(division.equalsIgnoreCase("") || office.equalsIgnoreCase(""))) {
				System.out.println("division name: " + division);
				DivisionOffice dOffice = new DivisionOffice(division, office);
				DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

				try {
					doManager.addDivisionOffice(dOffice);
					System.out.println("Saved division office successfully!");
					view = request.getRequestDispatcher("../divisions/SearchDivisionOffice.do");
				} catch (TransactionException e) {
					e.printStackTrace();
				} catch (DuplicateEntryException e) {
					e.printStackTrace();
				}
			}
		}
		view.forward(request, response);
	}
}
