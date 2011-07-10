package com.iappsam.servlet.entities.division;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.DivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.servlet.Action;

public class EditDivisionAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {

		String dOfficeID = request.getParameter("dOfficeID");

		DivisionOffice dOffice = null;
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

		try {
			dOffice = doManager.getDivisionOffice(Integer.parseInt(dOfficeID));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		if (dOffice != null) {
			request.setAttribute("dOffice", dOffice);
		}

		RequestDispatcher view = request.getRequestDispatcher(DivisionOfficeServlet.EDIT_DIVISION);
		view.forward(request, response);
	}

}
