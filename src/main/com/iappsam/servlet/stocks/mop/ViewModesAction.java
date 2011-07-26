package com.iappsam.servlet.stocks.mop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.managers.POManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.POManagerSession;
import com.iappsam.servlet.Action;

public class ViewModesAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		POManager poManager = new POManagerSession();
		RequestDispatcher view = request.getRequestDispatcher(ModeOfProcServlet.VIEW_MODES);
		
		List<ModeOfProcurement> modes = new ArrayList<ModeOfProcurement>();
		
		try {
			modes = poManager.getAllModeOfProcurement();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("modes", modes);
		
		view.forward(request, response);
	}
}
