package com.iappsam.servlet.stocks.mop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;
import com.iappsam.util.Verifier;

@WebServlet("/stocks/stocks/SaveEditedModeOfProc.do")
public class SaveEditedModeOfProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveEditedModeOfProc() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("inside saveeditedmop.java");

		RequestDispatcher save = request.getRequestDispatcher("EditModeOfProcurement.do");
		int mopID = Integer.parseInt(request.getParameter("mopID"));
		String name = request.getParameter("modeOfProcurementField");

		ModeOfProcurement mop = null;

		try {
			mop = Managers.INSTANCE.getPOManager().getModeOfProcurement(mopID);
			if (Verifier.validEntry(name)) {
				mop.setName(name);
				Managers.INSTANCE.getPOManager().updateModeOfProcurement(mop);
				save = request.getRequestDispatcher("ViewModesOfProcurement.do");
			} else {
				request.setAttribute("mop", mop);
			}
		} catch (TransactionException e) {
			e.printStackTrace();
			request.setAttribute("mop", mop);
		}

		save.forward(request, response);
	}

}
