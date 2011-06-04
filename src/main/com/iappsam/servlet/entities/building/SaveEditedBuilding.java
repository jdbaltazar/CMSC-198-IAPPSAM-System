package com.iappsam.servlet.entities.building;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Building;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;
import com.iappsam.util.Verifier;

/**
 * Servlet implementation class SaveEditedBuilding
 */
@WebServlet("/entities/building/SaveEditedBuilding.do")
public class SaveEditedBuilding extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEditedBuilding() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("....inside save editedbuilding.java");

		int buildingID = Integer.parseInt((String) request.getParameter("buildingID"));
		String name = (String) request.getParameter("name");
		String address = (String) request.getParameter("address");
		RequestDispatcher edit = request.getRequestDispatcher("EditBuilding.jsp");
		Building building = null;
		try {
			building = ManagerBin.doManager.getBuilding(buildingID);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (Verifier.validEntry(name) && Verifier.validEntry(address)) {
			building.setBuildingName(name);
			building.setBuildingAddress(address);
			try {
				ManagerBin.doManager.updateBuilding(building);
				edit = request.getRequestDispatcher("SearchBuilding.do");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		edit.forward(request, response);
	}

}
