package com.iappsam.servlet.stocks.mop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ApplicationContext;

@WebServlet("/stocks/stocks/EditModeOfProcurement.do")
public class EditModeOfProcurement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditModeOfProcurement() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(".........inside editmop.java");
		int mopID = Integer.parseInt(request.getParameter("mopID"));
		ModeOfProcurement mop = new ModeOfProcurement();
		RequestDispatcher edit = request.getRequestDispatcher("EditModeOfProc.jsp");
		try {
			mop = ApplicationContext.INSTANCE.getPOManager().getModeOfProcurement(mopID);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("mop", mop);
		edit.forward(request, response);
	}

}
