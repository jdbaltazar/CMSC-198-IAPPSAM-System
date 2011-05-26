package com.iappsam.servlet.stocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/stocks/stocks/SearchAllDisposal.do")
public class SearchAllDisposals extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7700104491260715251L;

	public SearchAllDisposals(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WMRManager wmrManager = new WMRManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("../../stocks/stocks/disposal/ViewDisposal.jsp");
		
		ArrayList<String> disposal = new ArrayList<String>();
		
		List<Disposal> disposals = new ArrayList<Disposal>();
		
		try {
			disposals = wmrManager.getAllDisposal();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Disposal d: disposals){
			disposal.add(d.getDisposal());
		}
		
		request.setAttribute("disposal", disposal);
		
		view.forward(request, response);
	}
}
