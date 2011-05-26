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
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;

@SuppressWarnings("serial")
@WebServlet("/entities/building/buildingCreate.do")
public class BuildingCreation extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private String name;
	private String buildingID;
	private String address;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("name");
		buildingID = request.getParameter("buildingID");
		address = request.getParameter("address");

		if (name.isEmpty())
			failedRequest(request, response);
		else
			succesfulRequest(request, response);
	}

	private void succesfulRequest(HttpServletRequest request, HttpServletResponse response) {
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("../../jsp/entities/building/CreateBuildingSuccess.jsp");
		request.setAttribute("name", name);
		request.setAttribute("address", address);
		request.setAttribute("buildingID", buildingID);
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			doManager.addBuilding(new Building(name, address));
		} catch (TransactionException e) {
			e.printStackTrace();
		} catch (DuplicateEntryException e) {
			e.printStackTrace();
		}

	}

		
	private void failedRequest(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher view = request.getRequestDispatcher("../../jsp/entities/building/CreateBuildingFail.jsp");
		request.setAttribute("name", "fail");
		request.setAttribute("address", address);
		request.setAttribute("buildingID", buildingID);
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