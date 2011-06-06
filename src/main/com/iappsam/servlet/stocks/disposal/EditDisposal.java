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
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;

/**
 * Servlet implementation class EditDisposal
 */
@WebServlet("/stocks/stocks/EditDisposal.do")
public class EditDisposal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditDisposal() {
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

		System.out.println("...inside editdisposal.java");

		int disposalID = Integer.parseInt((String) request.getParameter("disposalID"));
		Disposal disposal = new Disposal();
		RequestDispatcher edit = request.getRequestDispatcher("EditDisposal.jsp");
		try {
			disposal = Managers.wmrManager.getDisposal(disposalID);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("disposal", disposal);
		edit.forward(request, response);

	}

}