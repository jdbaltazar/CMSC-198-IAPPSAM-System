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

public class ViewDivisionsAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {

		List<DivisionOffice> dos = new ArrayList<DivisionOffice>();
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		List<DivisionOffice> result = new ArrayList<DivisionOffice>();

		try {
			dos = doManager.getAllDivisionOffice();

			for (DivisionOffice d : dos) {
				if (d.getOfficeName() == null)
					result.add(d);
			}

		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("divOffices", result);

		RequestDispatcher view = request.getRequestDispatcher(DivisionOfficeServlet.VIEW_DIVISIONS);
		view.forward(request, response);
	}

}
