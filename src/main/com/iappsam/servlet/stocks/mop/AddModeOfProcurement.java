package com.iappsam.servlet.stocks.mop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.managers.POManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.POManagerSession;
import com.iappsam.util.Validator;

@WebServlet("/stocks/stocks/AddModeOfProc.do")
public class AddModeOfProcurement extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddModeOfProcurement() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		POManager poManager = new POManagerSession();
		ModeOfProcurement modeofProc = new ModeOfProcurement();

		RequestDispatcher add = request.getRequestDispatcher("AddModeOfProc.jsp");

		String modeofP = request.getParameter("modeOfProcurementField").trim();

		if (Validator.validField(modeofP)) {
			modeofProc.setName(modeofP);

			try {
				poManager.addModeOfProcurement(modeofProc);
				add = request.getRequestDispatcher("ViewModesOfProcurement.do");
				System.out.println("mode was saved!!!!!!!!!!!!");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		add.forward(request, response);

	}
}
