package com.iappsam.servlet.stocks.mop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class EditModeAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mopID = Integer.parseInt(request.getParameter("mopID"));
		ModeOfProcurement mop = new ModeOfProcurement();
		RequestDispatcher edit = request.getRequestDispatcher(ModeOfProcServlet.EDIT_MODE);
		try {
			mop = ApplicationContext.INSTANCE.getPOManager().getModeOfProcurement(mopID);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("mop", mop);
		edit.forward(request, response);
	}

}
