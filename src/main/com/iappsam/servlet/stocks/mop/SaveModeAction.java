package com.iappsam.servlet.stocks.mop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.logging.Logger;
import com.iappsam.managers.POManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.POManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveModeAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		POManager poManager = new POManagerSession();
		ModeOfProcurement modeofProc = new ModeOfProcurement();

		RequestDispatcher add = request.getRequestDispatcher(ModeOfProcServlet.ADD_MODE);
		String modeofP = request.getParameter("modeOfProcurementField").trim();

		if (Validator.validField(modeofP)) {
			modeofProc.setName(modeofP);
			try {
				poManager.addModeOfProcurement(modeofProc);
				Logger.log(request, new java.sql.Date((new java.util.Date()).getTime()), "Mode \""+modeofP+"\" was added");
				Action vAction = new ViewModesAction();
				vAction.process(request, response);
				return;
			} catch (TransactionException e) {
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				e.printStackTrace();
			}
		}

		add.forward(request, response);
	}

}
