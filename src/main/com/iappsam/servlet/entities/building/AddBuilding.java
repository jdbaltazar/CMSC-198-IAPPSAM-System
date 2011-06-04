package com.iappsam.servlet.entities.building;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Building;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.util.ManagerBin;
import com.iappsam.util.Verifier;

@SuppressWarnings("serial")
@WebServlet("/entities/building/AddBuilding.do")
public class AddBuilding extends HttpServlet {
	
	public AddBuilding(){
		super();	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("...inside addbuilding");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddBuilding.jsp");
		
		String name = (String) request.getParameter("name");
		String address = (String) request.getParameter("address");
		
		if(Verifier.validEntry(name)&&Verifier.validEntry(address)){
			Building building = new Building(name, address);
			try {
				ManagerBin.doManager.addBuilding(building);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		requestDispatcher.forward(request, response);
	}

}