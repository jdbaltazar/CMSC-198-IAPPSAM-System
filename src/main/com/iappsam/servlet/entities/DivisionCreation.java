package com.iappsam.servlet.entities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Building;
import com.iappsam.entities.DivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;

/**
 * Servlet implementation class DivisionCreation
 */
@WebServlet("/entities/division/divisionCreate.do")
public class DivisionCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String building;
	private String currentOIC;
	private int divisionID;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

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
	private void succesfulRequest(HttpServletRequest request, HttpServletResponse response) {
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("../../jsp/entities/division/CreateDivisionSuccess.jsp");
		request.setAttribute("name", name);
		request.setAttribute("building", building);
		request.setAttribute("divisionID", divisionID);
		request.setAttribute("currentOIC", currentOIC);
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			doManager.addDivisionOffice(new DivisionOffice(name, "", divisionID));
//
//		} catch (TransactionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("name");
		building = request.getParameter("building");
		currentOIC = request.getParameter("currentOIC");
		System.out.println(currentOIC);
		if (name==null||currentOIC==null||name.isEmpty() || currentOIC.isEmpty()) {
			failRequest(request, response);
		} else
			succesfulRequest(request, response);
	}

	private void failRequest(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher view = request.getRequestDispatcher("../../jsp/entities/division/CreateDivisionFail.jsp");
		request.setAttribute("name", name);
		if (name==null||name.isEmpty())
			request.setAttribute("nameOK", "fail");
		else
			request.setAttribute("nameOK", "true");
		request.setAttribute("building", building);
		if(building==null||building.isEmpty())
			request.setAttribute("buildingOK", "fail");
		else
			request.setAttribute("buildingOK", "true");
		
		request.setAttribute("divisionID", ""+divisionID);
		if(divisionID==0)
			request.setAttribute("divisionIDOK", "fail");
		else
			request.setAttribute("divisionIDOK", "true");
		request.setAttribute("currentOIC", currentOIC);
		
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
