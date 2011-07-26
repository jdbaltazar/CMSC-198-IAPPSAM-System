package com.iappsam.servlet.entities.building;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Building;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.servlet.Action;

public class ViewBuildingsAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		RequestDispatcher view = request.getRequestDispatcher(BuildingServlet.VIEW_BUILDINGS);

		List<Building> buildings = new ArrayList<Building>();

		try {
			buildings = doManager.getAllBuildings();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		request.setAttribute("buildings", buildings);
		view.forward(request, response);
	}
}
