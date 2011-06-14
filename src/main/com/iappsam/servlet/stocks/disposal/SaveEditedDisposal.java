package com.iappsam.servlet.stocks.disposal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.forms.Disposal;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;
import com.iappsam.util.Verifier;

/**
 * Servlet implementation class SaveEditedDisposal
 */
@WebServlet("/stocks/stocks/SaveEditedDisposal.do")
public class SaveEditedDisposal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEditedDisposal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println(".....inside saveediteddisposal.java");

		RequestDispatcher save = request.getRequestDispatcher("EditDisposal.do");
		int disposalID = Integer.parseInt(request.getParameter("disposalID"));
		String name = request.getParameter("disposalField");

		Disposal disposal = null;

		try {
			disposal = Managers.wmrManager.getDisposal(disposalID);
			if (Verifier.validEntry(name)) {
				disposal.setName(name);
				Managers.wmrManager.updateDisposal(disposal);
				save = request.getRequestDispatcher("ViewDisposals.do");
			} else {
				request.setAttribute("disposal", disposal);
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("disposal", disposal);
		}

		save.forward(request, response);
	}

}
