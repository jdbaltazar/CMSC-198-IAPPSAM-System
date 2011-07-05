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
import com.iappsam.util.Validator;

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
		if(name!=null)
			name = name.trim();
		String address = request.getParameter("address");
		if(address!=null)
			address = address.trim();

		if (Validator.validField(name)) {
			building.setName(name);
			building.setAddress(address);
			try {
				ApplicationContext.INSTANCE.getDivisionOfficeManager().addBuilding(building);
				add = request.getRequestDispatcher("ViewBuildings.do");
				System.out.println("building was saved!!");
			} catch (TransactionException e) {
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				e.printStackTrace();
			}
		}

		add.forward(request, response);
	}

}