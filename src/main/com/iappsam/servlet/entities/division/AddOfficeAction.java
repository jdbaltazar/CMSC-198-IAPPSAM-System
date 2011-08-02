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
import com.iappsam.util.ApplicationContext;

public class AddOfficeAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int dOfficeID = Integer.parseInt(request.getParameter("dOfficeID"));

		DivisionOffice dOffice;
		try {
			dOffice = ApplicationContext.INSTANCE.getDivisionOfficeManager().getDivisionOffice(dOfficeID);
			request.setAttribute("dOffice", dOffice);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher(DivisionOfficeServlet.ADD_OFFICE);
		view.forward(request, response);
	}

}
