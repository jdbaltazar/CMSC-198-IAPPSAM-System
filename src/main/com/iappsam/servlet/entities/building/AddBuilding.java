package com.iappsam.servlet.entities.building;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Building;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ApplicationContext;
import com.iappsam.util.Verifier;

@SuppressWarnings("serial")
@WebServlet("/entities/building/AddBuilding.do")
public class AddBuilding extends HttpServlet {

	public AddBuilding() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("...inside addbuilding");

		RequestDispatcher add = request.getRequestDispatcher("AddBuilding.jsp");
		Building building = new Building();
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		if (Verifier.validEntry(name)) {
			building.setBuildingName(name);
			building.setBuildingAddress(address);
			try {
				ApplicationContext.INSTANCE.getDivisionOfficeManager().addBuilding(building);
				add = request.getRequestDispatcher("ViewBuildings.do");
				System.out.println("building was saved!!");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		add.forward(request, response);
	}

}