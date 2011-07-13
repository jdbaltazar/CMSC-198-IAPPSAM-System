package com.iappsam.servlet.stocks.disposal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Disposal;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class EditDisposalAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		System.out.println("...inside editdisposal.java");

		int disposalID = Integer.parseInt(request.getParameter("disposalID"));
		Disposal disposal = new Disposal();
		RequestDispatcher edit = request.getRequestDispatcher(DisposalServlet.EDIT_DISPOSAL);
		try {
			disposal = ApplicationContext.INSTANCE.getWMRManager().getDisposal(disposalID);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("disposal", disposal);
		edit.forward(request, response);
	}

}
