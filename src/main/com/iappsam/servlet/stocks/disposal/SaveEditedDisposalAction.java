package com.iappsam.servlet.stocks.disposal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Disposal;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;
import com.iappsam.util.Validator;

public class SaveEditedDisposalAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Action action = new EditDisposalAction();

		int disposalID = Integer.parseInt(request.getParameter("disposalID"));
		String name = request.getParameter("disposalField").trim();

		Disposal disposal = null;

		try {
			disposal = ApplicationContext.INSTANCE.getWMRManager().getDisposal(disposalID);
			if (Validator.validField(name)) {
				disposal.setName(name);
				ApplicationContext.INSTANCE.getWMRManager().updateDisposal(disposal);
				Action vAction = new ViewDisposalsAction();
				vAction.process(request, response);
				return;
			}
		} catch (TransactionException e) {
			e.printStackTrace();
			request.setAttribute("disposal", disposal);
		}

		request.setAttribute("disposalID", "" + disposalID);
		action.process(request, response);
	}

}
