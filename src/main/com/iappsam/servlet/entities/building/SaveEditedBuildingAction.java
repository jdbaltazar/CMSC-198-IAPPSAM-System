package com.iappsam.servlet.entities.building;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Building;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;
import com.iappsam.util.Validator;

public class SaveEditedBuildingAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Action action = new EditBuildingAction();

		int buildingID = Integer.parseInt(request.getParameter("buildingID"));
		String name = request.getParameter("name");
		if (name != null)
			name = name.trim();
		String address = request.getParameter("address").trim();
		if (address != null)
			address = address.trim();
		Building building = null;
		try {
			building = ApplicationContext.INSTANCE.getDivisionOfficeManager().getBuilding(buildingID);
			if (Validator.validField(name)) {
				building.setName(name);
				building.setAddress(address);
				try {
					ApplicationContext.INSTANCE.getDivisionOfficeManager().updateBuilding(building);
					Action vAction = new ViewBuildingsAction();
					vAction.process(request, response);
					return;
				} catch (TransactionException e) {
					e.printStackTrace();

				}
			}
		} catch (TransactionException e) {
			e.printStackTrace();
			request.setAttribute("building", building);
		}

		request.setAttribute("building", building);
		action.process(request, response);
	}

}
