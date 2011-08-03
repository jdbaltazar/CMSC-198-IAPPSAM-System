package com.iappsam.servlet.entities.division;

import java.io.IOException;
import java.util.List;

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

public class SaveOfficeAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dOfficeID = Integer.parseInt(request.getParameter("dOfficeID"));
		String officeName = request.getParameter("officeName").trim();

		RequestDispatcher view = request.getRequestDispatcher(DivisionOfficeServlet.ADD_OFFICE);
		DivisionOffice office, newOffice;
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		try {
			office = doManager.getDivisionOffice(dOfficeID);
			DivisionOffice dOffice = doManager.getDivisionOffice(office.getDivisionName(), null);

			if (officeName != null && !officeName.equalsIgnoreCase("")) {
				newOffice = new DivisionOffice(office.getDivisionName(), officeName);
				doManager.addDivisionOffice(newOffice);
				Logger.log(request, new java.sql.Date((new java.util.Date()).getTime()), "Office \""+officeName+"\" was added");
				List<DivisionOffice> offices = doManager.getOfficesUnderDivision(office.getDivisionName());

				request.setAttribute("offices", offices);
				request.setAttribute("dOfficeID", "" + dOffice.getId());
				Action vAction = new ViewOfficesAction();
				vAction.process(request, response);
				return;
			} else {
				request.setAttribute("dOffice", dOffice);
			}

		} catch (TransactionException e) {
			e.printStackTrace();
		} catch (DuplicateEntryException e) {
			e.printStackTrace();
		}

		view.forward(request, response);
	}

}
