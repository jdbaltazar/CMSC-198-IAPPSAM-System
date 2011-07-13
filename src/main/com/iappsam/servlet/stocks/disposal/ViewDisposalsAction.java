package com.iappsam.servlet.stocks.disposal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Disposal;
import com.iappsam.managers.WMRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.WMRManagerSession;
import com.iappsam.servlet.Action;

public class ViewDisposalsAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		WMRManager wmrManager = new WMRManagerSession();
		RequestDispatcher view = request.getRequestDispatcher(DisposalServlet.VIEW_DISPOSALS);

		List<Disposal> disposals = new ArrayList<Disposal>();

		try {
			disposals = wmrManager.getAllDisposal();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("disposals", disposals);
		view.forward(request, response);
	}

}
