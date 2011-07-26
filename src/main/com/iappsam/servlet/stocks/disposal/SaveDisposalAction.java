package com.iappsam.servlet.stocks.disposal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Disposal;
import com.iappsam.managers.WMRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.WMRManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveDisposalAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WMRManager wmrManager = new WMRManagerSession();
		Disposal disposal = new Disposal();

		RequestDispatcher add = request.getRequestDispatcher(DisposalServlet.ADD_DISPOSAL);
		String disposalInput = request.getParameter("disposalField").trim();
		if (Validator.validField(disposalInput)) {
			disposal.setName(disposalInput);
			try {
				wmrManager.addDisposal(disposal);
				System.out.println("disposal was saved!!");
				Action vAction = new ViewDisposalsAction();
				vAction.process(request, response);
				return;
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}
		add.forward(request, response);
	}

}
