package com.iappsam.servlet.entities.building;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/entities/building/ViewBuildings.do")
public class ViewBuildings extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewBuildings() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("ViewBuildings.jsp");

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
