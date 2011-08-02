package com.iappsam.servlet.entities.division;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.DivisionOffice;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class EditOfficeAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int officeID = Integer.parseInt(request.getParameter("officeID"));
		DivisionOffice office = null;
		try {
			office = ApplicationContext.INSTANCE.getDivisionOfficeManager().getDivisionOffice(officeID);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		request.setAttribute("office", office);
		RequestDispatcher view = request.getRequestDispatcher(DivisionOfficeServlet.EDIT_OFFICE);

		view.forward(request, response);
	}

}
