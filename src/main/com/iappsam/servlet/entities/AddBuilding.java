package com.iappsam.servlet.entities;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Building;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;

@SuppressWarnings("serial")
@WebServlet("/entities/building/saveBuilding.do")
public class AddBuilding extends HttpServlet {
	
	public AddBuilding(){
		super();	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		Building building = new Building();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("SearchAllBuildings.do");//("../../entities/building/AddBuilding.jsp");
		
		String name = (String) request.getParameter("name");
		String address = (String) request.getParameter("address");
		
		building.setBuildingName(name);
		building.setBuildingAddress(address);
		
		request.setAttribute("building", building);

		try {
			doManager.addBuilding(building);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// request.setAttribute("description", description);
		//requestDispatcher = request.getRequestDispatcher("building/AddBuilding.jsp");
		requestDispatcher.forward(request, response);
	}

}