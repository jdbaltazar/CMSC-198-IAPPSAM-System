package com.iappsam.servlet.entities.division;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.DivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.servlet.Action;

public class ViewOfficesAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {

		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

		String divisionID = request.getParameter("dOfficeID");

		if (divisionID == null)
			divisionID = (String) request.getAttribute("dOfficeID");
		DivisionOffice dOffice = null;
		List<DivisionOffice> offices = new ArrayList<DivisionOffice>();

		RequestDispatcher view = null;

		try {
			dOffice = doManager.getDivisionOffice(Integer.parseInt(divisionID));
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		if (dOffice != null) {
			try {
				offices = doManager.getOfficesUnderDivision(dOffice.getDivisionName());
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("dOffice", dOffice);
		request.setAttribute("offices", offices);

		view = request.getRequestDispatcher(DivisionOfficeServlet.VIEW_OFFICES);
		view.forward(request, response);
	}

}
