package com.iappsam.servlet.entities.division;

import java.io.IOException;
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

public class SaveEditedOfficeAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		int officeID = Integer.parseInt(request.getParameter("officeID"));
		String newName = request.getParameter("newName").trim();

		RequestDispatcher view = request.getRequestDispatcher(DivisionOfficeServlet.EDIT_OFFICE);
		DivisionOffice office;
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

		try {
			office = doManager.getDivisionOffice(officeID);
			if (newName != null && !newName.equalsIgnoreCase("")) {
				office.setOfficeName(newName);
				doManager.updateDivisionOffice(office);
				List<DivisionOffice> offices = doManager.getOfficesUnderDivision(office.getDivisionName());
				DivisionOffice dOffice = doManager.getDivisionOffice(office.getDivisionName(), null);
				request.setAttribute("offices", offices);
				request.setAttribute("dOfficeID", ""+dOffice.getId());
				Action vAction = new ViewOfficesAction();
				vAction.process(request, response);
				return;
			} else {
				request.setAttribute("office", office);
			}

		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view.forward(request, response);
	}

}
