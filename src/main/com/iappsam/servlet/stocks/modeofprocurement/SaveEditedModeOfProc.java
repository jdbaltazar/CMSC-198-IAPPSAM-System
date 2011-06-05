package com.iappsam.servlet.stocks.modeofprocurement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;
import com.iappsam.util.Verifier;

/**
 * Servlet implementation class SaveEditedModeOfProc
 */
@WebServlet("/stocks/stocks/SaveEditedModeOfProc.do")
public class SaveEditedModeOfProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEditedModeOfProc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("inside saveeditedmop.java");

		RequestDispatcher save = request.getRequestDispatcher("EditModeOfProcurement.do");
		int mopID = Integer.parseInt((String) request.getParameter("mopID"));
		String name = (String) request.getParameter("modeOfProcurementField");

		ModeOfProcurement mop = null;

		try {
			mop = ManagerBin.poManager.getModeOfProcurement(mopID);
			if (Verifier.validEntry(name)) {
				mop.setModeOfProcurement(name);
				ManagerBin.poManager.updateModeOfProcurement(mop);
				save = request.getRequestDispatcher("ViewModesOfProcurement.do");
			} else {
				request.setAttribute("mop", mop);
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("mop", mop);
		}

		save.forward(request, response);
	}

}
