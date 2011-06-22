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

public class ViewDivisionsAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		// TODO Auto-generated method stub

		List<DivisionOffice> dos = new ArrayList<DivisionOffice>();
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		RequestDispatcher view = request.getRequestDispatcher(DivisionServlet.VIEW_DIVISIONS);

		try {
			List<DivisionOffice> temp = doManager.getAllDivisionOffice();
			for (DivisionOffice d : temp) {
				if (d.getOfficeName() == null)
					dos.add(d);
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("divOffices", dos);
		view.forward(request, response);
	}

}
