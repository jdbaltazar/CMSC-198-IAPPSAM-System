package com.iappsam.servlet.stocks;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.POManagerSession;

@WebServlet("/stocks/stocks/AddMode.do")
public class AddModeofProcurement extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddModeofProcurement(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		POManager poManager = new POManagerSession();
		ModeOfProcurement modeofProc = new ModeOfProcurement();
		
		RequestDispatcher add = request.getRequestDispatcher("SearchAllModes.do");

		String modeofP = (String) request.getParameter("modeOfProcurementField");
		
		modeofProc.setModeOfProcurement(modeofP);
		
		request.setAttribute("modeofProc", modeofProc);
		
		try {
			poManager.addModeOfProcurement(modeofProc);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add.forward(request, response);
		
	}
}

