package com.iappsam.servlet.entities.building;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Building;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class EditBuildingAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int buildingID = Integer.parseInt(request.getParameter("buildingID"));
		Building building = null;
		RequestDispatcher edit = request.getRequestDispatcher(BuildingServlet.EDIT_BUILDING);
		try {
			building = ApplicationContext.INSTANCE.getDivisionOfficeManager().getBuilding(buildingID);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("building", building);
		edit.forward(request, response);
	}

}
