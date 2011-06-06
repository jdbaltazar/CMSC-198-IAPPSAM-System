package com.iappsam.servlet.stocks.disposal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.forms.Disposal;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.WMRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.WMRManagerSession;
import com.iappsam.util.Verifier;

@WebServlet("/stocks/stocks/AddDisposal.do")
public class AddDisposal extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddDisposal() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(".........inside adddisposal.java");
		WMRManager wmrManager = new WMRManagerSession();
		Disposal disposal = new Disposal();

		RequestDispatcher add = request.getRequestDispatcher("AddDisposal.jsp");

		String disposalInput = (String) request.getParameter("disposalField");

		if (Verifier.validEntry(disposalInput)) {
			disposal.setName(disposalInput);

			try {
				wmrManager.addDisposal(disposal);
				add = request.getRequestDispatcher("ViewDisposals.do");
				System.out.println("disposal was saved!!");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			add = request.getRequestDispatcher("AddDisposal.jsp");
		}
		add.forward(request, response);

	}
}