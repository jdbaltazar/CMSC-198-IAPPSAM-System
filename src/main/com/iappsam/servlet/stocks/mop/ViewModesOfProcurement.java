package com.iappsam.servlet.stocks.mop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.managers.POManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.POManagerSession;

@WebServlet("/stocks/stocks/ViewModesOfProcurement.do")
public class ViewModesOfProcurement extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7700104491260715251L;

	public ViewModesOfProcurement(){
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		POManager poManager = new POManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("ViewModesOfProcurement.jsp");
		
		List<ModeOfProcurement> modes = new ArrayList<ModeOfProcurement>();
		
		try {
			modes = poManager.getAllModeOfProcurement();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("modes", modes);
		
		view.forward(request, response);
	}
}
