package com.iappsam.servlet.entities.building;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Building;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;
import com.iappsam.util.Validator;

public class SaveBuildingAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher add = request.getRequestDispatcher(BuildingServlet.ADD_BUILDING);
		Building building = new Building();
		String name = request.getParameter("name");
		if (name != null)
			name = name.trim();
		String address = request.getParameter("address");
		if (address != null)
			address = address.trim();

		if (Validator.validField(name)) {
			building.setName(name);
			building.setAddress(address);
			try {
				ApplicationContext.INSTANCE.getDivisionOfficeManager().addBuilding(building);
				Action vAction = new ViewBuildingsAction();
				vAction.process(request, response);
				return;
			} catch (TransactionException e) {
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				e.printStackTrace();
			}
		}

		add.forward(request, response);
	}

}
