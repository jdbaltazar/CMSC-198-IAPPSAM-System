package com.iappsam.servlet.entities.division;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.DivisionOffice;
import com.iappsam.logging.Logger;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveDivisionAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher(DivisionOfficeServlet.ADD_DIVISION);
		String divisionName = request.getParameter("divisionName").trim();

		if (Validator.validField(divisionName)) {
			DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
			DivisionOffice dOffice = new DivisionOffice(divisionName, null);
			try {
				doManager.addDivisionOffice(dOffice);
				Logger.log(request, new java.sql.Date((new java.util.Date()).getTime()), "Division \""+divisionName+"\" was added");
				Action vAction = new ViewDivisionsAction();
				vAction.process(request, response);
				return;
			} catch (TransactionException e) {
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				view = request.getRequestDispatcher(DivisionOfficeServlet.ADD_DIVISION);
				request.setAttribute("isReturning", "true");
				view.forward(request, response);
			}
		} else {
			view = request.getRequestDispatcher(DivisionOfficeServlet.ADD_DIVISION);
			request.setAttribute("isEmpty", "true");
			view.forward(request, response);
		}
	}

}
