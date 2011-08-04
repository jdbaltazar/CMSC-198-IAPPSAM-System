package com.iappsam.servlet.stocks.mop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.logging.Logger;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;
import com.iappsam.util.Validator;

public class SaveEditedModeAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Action action = new EditModeAction();

		int mopID = Integer.parseInt(request.getParameter("mopID"));
		String name = request.getParameter("modeOfProcurementField").trim();

		ModeOfProcurement mop = null;

		try {
			mop = ApplicationContext.INSTANCE.getPOManager().getModeOfProcurement(mopID);
			if (Validator.validField(name)) {
				mop.setName(name);
				ApplicationContext.INSTANCE.getPOManager().updateModeOfProcurement(mop);
				Logger.log(request, "Mode \""+name+"\" was updated");
				Action vAction = new ViewModesAction();
				vAction.process(request, response);
				return;
			}
		} catch (TransactionException e) {
			e.printStackTrace();
			request.setAttribute("mop", mop);
		}

		request.setAttribute("mopID", "" + mopID);
		action.process(request, response);
	}
}
