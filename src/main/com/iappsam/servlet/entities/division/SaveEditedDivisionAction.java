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
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.servlet.Action;

public class SaveEditedDivisionAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher(DivisionOfficeServlet.EDIT_DIVISION);

		String dOfficeID = request.getParameter("dOfficeID");
		String newName = request.getParameter("newName").trim();

		if (dOfficeID != null) {
			DivisionOffice dOffice = null;
			DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

			try {
				dOffice = doManager.getDivisionOffice(Integer.parseInt(dOfficeID));
				if (dOffice != null && newName != null) {
					if (!newName.equalsIgnoreCase("")) {

						List<DivisionOffice> dOffices = doManager.getAllDivisionOffice();
						for (DivisionOffice d : dOffices) {
							if (d.getDivisionName().equalsIgnoreCase(dOffice.getDivisionName())) {
								d.setDivisionName(newName);
								doManager.updateDivisionOffice(d);
							}
						}
						dOffice.setDivisionName(newName);
						doManager.updateDivisionOffice(dOffice);
						Logger.log(request, new java.sql.Date((new java.util.Date()).getTime()), "Division \""+newName+"\" was updated");
						Action vAction = new ViewOfficesAction();
						vAction.process(request, response);
						return;
					}
				}
				request.setAttribute("dOffice", dOffice);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}
		view.forward(request, response);
	}

}
