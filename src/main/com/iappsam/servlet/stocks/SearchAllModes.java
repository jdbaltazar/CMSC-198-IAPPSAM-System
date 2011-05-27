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
import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.POManagerSession;

@WebServlet("/stocks/stocks/SearchAllModes.do")
public class SearchAllModes extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7700104491260715251L;

	public SearchAllModes(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		POManager poManager = new POManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("ViewModeOfProcurement.jsp");
		
		ArrayList<String> mode = new ArrayList<String>();
		
		List<ModeOfProcurement> modes = new ArrayList<ModeOfProcurement>();
		
		try {
			modes = poManager.getAllModeOfProcurement();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ModeOfProcurement mop: modes){
			mode.add(mop.getModeOfProcurement());
		}
		
		request.setAttribute("mode", mode);
		
		view.forward(request, response);
	}
}
